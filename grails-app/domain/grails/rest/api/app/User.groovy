package grails.rest.api.app


import grails.rest.*

@Resource(readOnly = false, formats = ['json', 'xml'])
class User {
    String name
    String address
    Date dateOfBirth

    Set<Property> houses = [].toSet()

    static hasMany = [houses: Property]

    static constraints = {
        //dateOfBirth nullable: true
    }
}