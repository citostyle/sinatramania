require 'sinatra'
require 'sinatra/namespace'
require 'sinatra/json'
require 'json'

require 'sinatra/reloader'

set :port, 3000
enable :sessions

namespace '/todos' do

  get '/?' do
    json []
  end

  put '/?' do
    json_request = request.body.read
    todo = JSON.parse(json_request)
    session[:todos] ||= []
    session[:todos] << todo
    status 201
  end

end
