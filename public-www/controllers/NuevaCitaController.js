(function() {
    
    angular.module('petclinicPublic')
        .controller('NuevaCitaController', NuevaCitaController);
    
    function NuevaCitaController(citasFactory,$state,$stateParams,ownersFactory) {        
        var vm = this;  
        var id = ownersFactory.getCurrentOwner().id;
        
        citasFactory.getCitas().then(function(d){
           vm.citas = d.data;
        });
        
        vm.getCitasHistoricas = function(){
            citasFactory.getHistorico().then(function(d){
                vm.citasHistorico = d.data;
            });
        }
        vm.createCita = function(){
            //var id = vm.citas[vm.citas.length-1].id; 
            //id+1
            var c = {'vetId':vm.vetSelect,'petId':vm.petSelect,'visitDate':vm.citaDate};
            citasFactory.createCita(c,id).then(function(res){
                console.log(res.data)
            });
            //vm.citas.push(o);
        }
        
        citasFactory.getMascotas(id).then(function(d){
               vm.mascotas = d.data;
            });
        citasFactory.getVeterinariosDisponibles().then(function(d){
               vm.veterinarios = d.data;
            });
        
        vm.setEditVisit = function(requestId){
            citasFactory.setEditState(requestId).then(function(res){
                console.log(res.data)
                    vm.visit = res.data;
                if(vm.citas[vm.visit.id-1].state==0) {
                    vm.citas[vm.visit.id-1].state=1;
                }else{
                    vm.citas[vm.visit.id-1].state=0;
                }
            });
        }
        
    }    
    
}());