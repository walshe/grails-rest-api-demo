package grails.rest.api.app

import grails.rest.Resource

/**
 * Created by newadmin on 16/02/2016.
 */
@Resource(readOnly = false, formats = ['json', 'xml'])
class Property {

    String type
    String name

    User user
    static belongsTo = [user:User]

}
