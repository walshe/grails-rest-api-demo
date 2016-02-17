package grails.rest.api.app


import grails.test.mixin.integration.Integration
import grails.transaction.*
import static grails.web.http.HttpHeaders.*
import static org.springframework.http.HttpStatus.*
import spock.lang.*
import geb.spock.*
import grails.plugins.rest.client.RestBuilder

@Integration
@Rollback
class UserSpec extends GebSpec {

    @Shared
    def grailsApplication


    def setup() {
        //new User(name: 'joe', address: 'castlebar').save()
    }

    def cleanup() {
    }

    void "Test user list"() {
        when:"The user list is requested"
            def resp = restBuilder().get("$baseUrl/user")

        then:"The response is correct"
            resp.status == OK.value()
            resp.headers[CONTENT_TYPE] == ['application/json;charset=UTF-8']
            resp.json[0].name == 'Emmett0'
    }


    void "Test get one user"() {
        when:"The user page is requested"
        def resp = restBuilder().get("$baseUrl/user/show/1")

        then:"The response is correct"
        resp.status == OK.value()
        resp.headers[CONTENT_TYPE] == ['application/json;charset=UTF-8']
        resp.json.name == 'Emmett0'
    }

    void "test create user"(){


        when: "a user is posted"
        def resp = restBuilder().post("$baseUrl/user/save/",{
            contentType("application/json")
            json([name:'fred', address:'foo', dateOfBirth: new Date().format("yyyy-MM-dd HH:mm:ss.SSS ZZZZ")])
        })

        then:"The response is correct"
        resp.status == CREATED.value()

    }

    void "test delete user"(){


        when: "a user is deleted"
        def resp = restBuilder().delete("$baseUrl/user/delete/1",{
            contentType("application/json")
        })

        then:"The response is correct"
        resp.status == NO_CONTENT.value()

    }

    void "test update user"(){


        when: "a user is updated"
            def resp = restBuilder().put("$baseUrl/user/update/2",{
            contentType("application/json")
            json([name:'nameupdate'])
        })

        then:"The response is correct"
        resp.status == OK.value()

        println( resp.json)

    }




    RestBuilder restBuilder() {
        new RestBuilder()
    }
}
