Sinatramania
============

The easy design of the Ruby Framework Sinatra[1] has inspired[2] many further frameworks in various programming languages. Sinatra's basic functionality can be seen as a DSL in the domain of HTTP Requests. Sinatramania aims on comparing the different frameworks by implementing the same simple API (that handles todo list entries) in the different programming languages.

DSL
===========

Looking at the simple example on the homepage[1]...

    get '/hi' do
      "Hello World!"
    end

... each handled request in the DSL  is a triple of < HTTP Verb, Resource/Path, Behaviour/Function > 

[1] (http://www.sinatrarb.com/)[http://www.sinatrarb.com/)
[2] [Frameworks inspired by Sinatra](http://en.wikipedia.org/wiki/Sinatra_\(software\)#Frameworks_inspired_by_Sinatra)
