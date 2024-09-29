package pe.edu.cibertec.rueditas_backend_t1.service;

import pe.edu.cibertec.rueditas_backend_t1.dto.VehiculoRequestDTO;


public interface VehiculoService {

    String [] buscarvehiculo(VehiculoRequestDTO vehiculoRequestDTO) throws Exception;
}
