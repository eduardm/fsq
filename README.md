fsq
===

FoursquareAuthenticate Grails plugin
==========================

# Introduction

The [Foursquare Platform](https://developer.foursquare.com) is a set of APIs that make your application more social. Read more about [integrating Foursquare with your web site](https://developer.foursquare.com/overview/auth) on the Foursquare developer site.

This project contains the open source **Grails Foursquare Authenticate Plugin** that allows you to integrate the Foursquare Authenticate on a website/app powered by [Grails](http://grails.org).

I created this plugin because there are several plugins that handles the Foursquare API already, but none of them are taking care of the OAuth token aquisition.

**Grails Foursquare Plugin** provides the following Grails artefacts:

* **FsqTagLib** - A collection of tags to easily integrate Foursquare Authenticate in your GSPs.
* **FoursquareAuthenticationService** - Service used to obtain the OAuth token by exchanging the code obtained using the JS library.


# Installation

Declare the plugin dependency in the BuildConfig.groovvy file, as shown here:

```groovy
grails.project.dependency.resolution = {
    inherits("global") { }
		log "info"
		repositories {
				//your repositories
		}
		dependencies {
				//your regular dependencies
		}
		plugins {
				//here go your plugin dependencies
				runtime ':foursquare-authenticate:0.4'
		}
}
```


# Config

Create a Foursquare app on [Foursquare Developers](https://foursquare.com/developers/apps), in order to get your own app ID and app secret.

Add your Foursquare app parameters to your _grails-app/conf/Config.groovy_:

```groovy
[REQUIRED]
grails.plugin.foursquareauth.appId = {Client ID}
grails.plugin.foursquareauth.secret = {Client Secret}
grails.plugin.foursquareauth.callback = {Callback url}
[OPTIONAL]
grails.plugin.foursquareauth.proxyHost = {Proxy host}
grails.plugin.foursquareauth.proxyPort = {Proxy Port}
```

# Getting started with a demo app

If you want to quickly run the plugin on a demo app, you can download [FoursquareAuthenticationSampleApp](https://github.com/eduardm/FoursquareAuthenticationSampleApp).

# Documentation

Project documentation is located here :

* [Reference Documentation](https://github.com/eduardm/fsq/wiki)

# Latest releases

* 2012-11-23 **V0.4** : First public release
* 2012-11-20 **V0.3** : Non public release
* 2012-11-3 **V0.2** : Non public release
* 2012-10-30 **V0.1** : Non public release


# Bugs

To report any bug, please use the project [Issues](https://github.com/eduardm/fsq/issues) section on GitHub.

# Beta status

This is a **beta release**.
The underlying APIs are generally stable, however we may make changes to the library in response to developer feedback.

# Feedback

The **Grails Foursquare Authenticate** is licensed under the [Apache Licence, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html).