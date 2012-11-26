package foursquare.authenticate

import wslite.rest.*

class FoursquareAuthenticationService {

    static transactional = false

    def grailsApplication

    def getOauthToken(code) {
        String status="failure"
		  def OAuthToken
        if (!code) {
            return [OAuthToken, status]
        }

		  def config = grailsApplication.config.grails.plugin.foursquareauth

        def (proxyHost, proxyPort) = [config.proxyHost, config.proxyPort]
        Proxy proxy
        if (proxyHost && proxyPort) {
            InetSocketAddress inetSocketAddress = new InetSocketAddress(proxyHost, proxyPort.toInteger());
            proxy = new Proxy(Proxy.Type.HTTP, inetSocketAddress);
        }
        def client = new RESTClient("https://foursquare.com/")
        def response = client.get(
                path: "/oauth2/access_token",
                query: [client_id: config.appId,
                        client_secret: config.secret,
                        grant_type: "authorization_code",
                        redirect_uri: config.callback,
                        code: code
                ],
                connectTimeout: 5000,
                readTimeout: 10000,
                followRedirects: false,
                useCaches: false,
                sslTrustAllCerts: true,
                proxy: proxy
        )
        if (response?.response?.statusCode == 200 && response?.parsedResponseContent?.json?.access_token) {
            status = "success"
            OAuthToken = response.parsedResponseContent.json.access_token
        }
        return [OAuthToken, status]
    }
}
