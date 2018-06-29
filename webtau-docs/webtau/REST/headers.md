# Standard Header

Standard headers like `Content-Type` and `Accept` are set on your behalf. 
When payload content is present then values are based on the content type you are sending. 
When no payload is present, it defaults to `application/json`.   

# Common Header

If each http request requires the same header you can specify that header using `httpHeaderProvider`. 
Common example is specifying authentication header.
 
:include-file: examples/rest/headers/webtau.cfg {title: "webtau.cfg"}

Where `Auth.&authHeader` is implemented as follows:

:include-file: examples/rest/headers/auth/Auth.groovy {title: "rest/headers/auth/Auth.groovy"}

This removes implementation details from your tests and makes them less brittle.  

# Explicit Header

To explicitly set header pass `http.header(values)` as an additional parameter.

:include-groovy: com/twosigma/webtau/http/HttpTest.groovy {entry: "explicit header passing example", bodyOnly: true}

Additionally `http.header` accepts values as a map.

:include-groovy: com/twosigma/webtau/http/HttpTest.groovy {entry: "header creation", bodyOnly: true}