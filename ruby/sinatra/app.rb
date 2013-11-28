require 'sinatra'
require 'sinatra/namespace'
require 'sinatra/json'

require 'sinatra/reloader'

set :port, 3000

namespace '/todos' do
  
  get '/?' do
       json []
  end

end
