import foursquare.authenticate.FoursquareAuthenticationService

class FoursquareAuthenticateGrailsPlugin {
    def version = "0.5"
    def grailsVersion = "2.0 > *"
    def title = "Foursquare Authenticate Plugin"
    def author = "Eduard Martini"
    def authorEmail = ""
    def description = '''\
    The Foursquare Platform is a set of APIs that make your application more social. Read more about integrating Foursquare with your web site on the Foursquare developer site.
    This project contains the open source Grails Foursquare Authenticate Plugin that allows you to integrate the Foursquare Authenticate on a website/app powered by Grails.
    I created this plugin because there are several plugins that handles the Foursquare API already, but none of them are taking care of the OAuth token aquisition.
    '''

    def documentation = "https://github.com/eduardm/fsq/wiki/Foursquare-Authenticate-Grails-plugin"

    def license = "APACHE"
    def issueManagement = [system: 'Github', url: 'https://github.com/eduardm/fsq/issues']
    def scm = [url: 'https://github.com/eduardm/fsq']

    def doWithSpring = {
        foursquareAuthenticationService(FoursquareAuthenticationService)
    }
}