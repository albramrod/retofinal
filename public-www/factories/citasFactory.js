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
            createCita: function(cita){
                return $http.post("http://localhost:8080/owner", owner);
            },
            getMascotas: function(){
                return $http.get();
            },
            getVeterinariosDisponibles: function(){
                return $http.get();
            }
            
            
        }
        return interfaz;
    }    
}())