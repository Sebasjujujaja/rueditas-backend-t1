package pe.edu.cibertec.rueditas_backend_t1.service.impl;

import pe.edu.cibertec.rueditas_backend_t1.dto.VehiculoRequestDTO;
import pe.edu.cibertec.rueditas_backend_t1.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class VehiculoServiceImpl implements VehiculoService {
    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] buscarvehiculo(VehiculoRequestDTO vehiculoRequestDTO) throws Exception {
        String[] datosVehiculo =null;
        Resource resource = resourceLoader.getResource("classpath:vehiculos.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
            //Implement

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if(     vehiculoRequestDTO.placa().equals(datos[1])){

                    datosVehiculo = new String[5];
                    datosVehiculo[0] = datos[2];//recupera marca
                    datosVehiculo[1] = datos[3];//recupera modelo
                    datosVehiculo[2] = datos[4];//recupera nroAsientos
                    datosVehiculo[3] = datos[5];//recupera precio
                    datosVehiculo[4] = datos[6];//recupera color
                }
            }

        }catch(IOException e){
            datosVehiculo =null;
            throw new IOException(e);
        }



        return datosVehiculo;
    }
}
