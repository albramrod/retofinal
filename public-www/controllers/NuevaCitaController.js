(function() {
    
    angular.module('petclinicPublic')
        .controller('NuevaCitaController', NuevaCitaController);
    
    function NuevaCitaController(citasFactory,$state,$stateParams) {        
        var vm = this;  
        
        citasFactory.getCitas().then(function(d){
           vm.citas = d.data;
        });
        
        vm.getCitasHistoricas = function(){
            citasFactory.getHistorico().then(function(d){
                vm.citasHistorico = d.data;
            });
        }
        vm.createCita = function(/**/){
            var id = vm.citas[vm.citas.length-1].id; 
            //id+1
            var o = {};
            citasFactory.createCita(o);
            vm.citas.push(o);
        }
        vm.getPets = function(){
            citasFactory.getMascotas().then(function(d){
               vm.mascotas = d.data;
            });
        }
        
        vm.getVetDisponibles = function(){ 
            citasFactory.getVeterinariosDisponibles().then(function(d){
               vm.veterinarios = d.data;
            });
        }
        
    }    
    
}());