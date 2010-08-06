This taglib provides LoopFuse (https://www.loopfuse.net/) page tracking integration for Grails.

You would typically include the tag in your main layout (/grails-app/views/layouts/main.gsp):
    <g:layoutBody />
    <lf:trackPageview/>
    
Depending on the version of Grails you may need to use the g: namespace instead.

There are two configuration settings:
    loopfuse.tracking.enabled = true
    loopfuse.tracking.cid = "your_code_here"

Note that the cid will be prefixed by **LF_** so don't include that.

This code is released under the [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0.html "Apache License, Version 2.0 - The Apache Software Foundation") and is not yet available in plugin form in the main Grails repositories.

The original intention was to add LoopFuse Web Services lead capture, as had been done from a custom Drupal module nicknamed **Droopfuse**, hence this ended up being called Gloopfuse.