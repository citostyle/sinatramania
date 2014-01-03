from flask import Flask, request, abort
from flask.ext import restful

app = Flask(__name__)
api = restful.Api(app)

todos = []

class TodosAPI(restful.Resource):
    def get(self):
        return todos
    
    def put(self):
        todo = request.json
        if not todo:
            abort(400)
        todos.append(todo)
        return todo, 201

api.add_resource(TodosAPI, '/todos')

if __name__ == "__main__":
    app.run(debug=True, port=3000)
