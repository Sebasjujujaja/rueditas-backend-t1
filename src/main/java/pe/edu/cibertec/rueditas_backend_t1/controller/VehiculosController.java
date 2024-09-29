package pe.edu.cibertec.rueditas_backend_t1.controller;

import pe.edu.cibertec.rueditas_backend_t1.dto.VehiculoRequestDTO;
import pe.edu.cibertec.rueditas_backend_t1.dto.VehiculoResponseDTO;
import pe.edu.cibertec.rueditas_backend_t1.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehiculo")
public class VehiculosController {

    @Autowired
    VehiculoService vehiculoService;


    @PostMapping("/buscar")
    public VehiculoResponseDTO buscar (@RequestBody VehiculoRequestDTO vehiculoRequestDTO) {

        try {
            String [] datosVehiculo = vehiculoService.buscarvehiculo(vehiculoRequestDTO);
            if(datosVehiculo == null) {
                return new VehiculoResponseDTO("02","Error: Vehiculo no encontrado","",
                        "","","","");
            }else {
                return new VehiculoResponseDTO("00","",datosVehiculo[0],datosVehiculo[1],
                        datosVehiculo[2],datosVehiculo[3],datosVehiculo[4]);
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new VehiculoResponseDTO("99","Error: Ocurrio un problema","",
                    "","","","");
        }

    }
}
