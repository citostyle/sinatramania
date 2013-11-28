require 'sinatra'
require 'sinatra/reloader'

set :port, 3000

get '/hi' do
  "Hello World!"
end
