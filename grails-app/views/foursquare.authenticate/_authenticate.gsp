<g:javascript>
    $("#${elementId}").click(function() {
        FSQ.authenticate({
            success: ${onSuccess ? onSuccess : "null"},
            failure: ${onFailure ? onFailure : "null"}
        })
    });
</g:javascript>