<g:javascript>
    var FSQ = {
        clientID:'${grailsApplication.config.grails.plugin.foursquareauth.appId}',
        responseType:"code",
        redirectURL:'${grailsApplication.config.grails.plugin.foursquareauth.callback}',
        baseAuthURL:"https://foursquare.com/oauth2/authenticate",

        authURL:function () {
            return this.baseAuthURL + "?client_id=" + this.clientID + "&response_type=" + this.responseType + "&redirect_uri=" + this.redirectURL ;
        },

        authenticate:function (cbks) {
            window.open(this.authURL(), '', 'height=520,width=620');
            $(document).bind("foursquare.authenticate.success", function(e, status) {
                if (cbks.success) {
                    console.log("we have cb for success")
                    cbks.success(e, status);
                }
            });
            $(document).bind("foursquare.authenticate.failed", function(e, status) {
                if (cbks.failure) {
                    cbks.failure(e, status);
                }
            });
        },

        handleCallback: function(status) {
            $(document).trigger("foursquare.authenticate." + status, [status]);
        }

    };
</g:javascript>