(function() {    
    angular.module('petclinicPublic')  
        .factory('citasFactory', citasFactory);     
    function citasFactory($http){ 
        
        var interfaz = {            
            
            getCitas:  function(){
                return $http.get('http://localhost:8080/requestvisits/list');
            },               
            getHistorico:  function(){
                return $http.get('http://localhost:8080/owner/'+ ownerId);
            },
            createCita: function(c, id){
                return $http.post('http://localhost:8080/requestvisit/'+id+'/newvisitrequest', c);
            },
            getMascotas: function(id){
               return $http.get('http://localhost:8080/owners/'+id+'/pets');
               
            },
            getVeterinariosDisponibles: function(){
                return $http.get('http://localhost:8080/vets');
            }
            ,
            setEditState: function(requestVisitId){
                return $http.put('http://localhost:8080/requestvisit/'+requestVisitId+'/changestate');
            }
            
        }
        return interfaz;
    }    
}())