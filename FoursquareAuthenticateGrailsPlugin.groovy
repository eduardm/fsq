import foursquare.authenticate.FoursquareAuthenticationService

class FoursquareAuthenticateGrailsPlugin {
    def version = "0.5"
    def grailsVersion = "2.0 > *"
    def title = "Foursquare Authenticate Plugin"
    def author = "Eduard Martini"
    def authorEmail = ""
    def description = 'Brief summary/description of the plugin.'

    def documentation = "http://grails.org/plugin/foursquare-authenticate"

//    def license = "APACHE"
    def issueManagement = [system: 'Github', url: 'https://github.com/eduardm/fsq/issues']
    def scm = [url: 'https://github.com/eduardm/fsq']

    def doWithSpring = {
        foursquareAuthenticationService(FoursquareAuthenticationService)
    }
}
