package foursquare.authenticate

import wslite.rest.*

class FoursquareAuthenticationService {
    static transactional = false
    def grailsApplication

    def getOauthToken(code) {
        def status="failure", OAuthToken = null
        if (!code)
            return [OAuthToken, status]
        def (proxyHost, proxyPort) = [grailsApplication.config.grails.plugin.foursquareauth.proxyHost, grailsApplication.config.grails.plugin.foursquareauth.proxyPort]
        Proxy proxy = null
        if (proxyHost && proxyPort) {
            InetSocketAddress inetSocketAddress = new InetSocketAddress(proxyHost, proxyPort.toInteger());
            proxy = new Proxy(Proxy.Type.HTTP, inetSocketAddress);
        }
        def client = new RESTClient("https://foursquare.com/")
        def response = client.get(
                path: "/oauth2/access_token",
                query: [client_id: grailsApplication.config.grails.plugin.foursquareauth.appId,
                        client_secret: grailsApplication.config.grails.plugin.foursquareauth.secret,
                        grant_type: "authorization_code",
                        redirect_uri: grailsApplication.config.grails.plugin.foursquareauth.callback,
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
