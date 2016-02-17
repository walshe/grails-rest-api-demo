import grails.rest.api.app.Property
import grails.rest.api.app.User

class BootStrap {

    def init = { servletContext ->



        (0..1).each{
            def user = User.findOrSaveWhere(name: "Emmett${it}", address: 'cornanool', dateOfBirth: new Date())
            Property.findOrSaveWhere(type: 'house', name:"house${it}", user: user)
            Property.findOrSaveWhere(type: 'house', name:"house${it}", user: user)
        }




    }
    def destroy = {
    }
}
