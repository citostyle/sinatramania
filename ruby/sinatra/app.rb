require 'sinatra'
require 'sinatra/namespace'
require 'sinatra/json'
require 'json'

require 'sinatra/reloader'

set :port, 3000

todos = []

namespace '/todos' do

  get '/?' do
    json todos
  end

  put '/?' do
    todo = JSON.parse(request.body.read)
    todos << todo
    status 201
  end

end
