package foursquare.authentication
class FsqTagLib {
    static namespace = "fsq"

    /**
     * Initialize Foursquare JS SDK
     * No attributes
     */
    def init = {
        out << render(template: "/foursquare.authenticate/initJs", plugin: "foursquare-authenticate")
    }

    /**
     * Ads the Foursquare login event to the specified element
     * @attr elementId HTML element 'id' attribute value
     * @attr onSuccess - javascript function that will be called when the OAuth token is retrieved with success
     * @attr onFailure - javascript function that will be called when the OAuth token is not retrieved (user denies, connection problem, etc)
     */
    def fsqLoginEvent = {attrs ->
        if (attrs["elementId"]) {
            out << render(template: "/foursquare.authenticate/authenticate", model: [elementId: attrs["elementId"], onSuccess: attrs["onSuccess"], onFailure: attrs["onFailure"]],
                    plugin: "foursquare-authenticate")
        }
    }

    /**
     * Should be included on the page where Foursquare redirects after authorize
     * @attr status Can be "success" or "failed" based on the obtaining or not the oauth token
     */
    def fsqHandleCallback = {attrs ->
        out << render(template: "/foursquare.authenticate/callback", model: [status: attrs["status"]], plugin: "foursquare-authenticate")
    }
}
