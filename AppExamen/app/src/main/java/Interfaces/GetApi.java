package Interfaces;

import Models.PersonaRespuesta;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by alan9 on 18/09/2018.
 */

public interface GetApi
{

    @GET("BringAllPersona")
    Call<PersonaRespuesta> obtenerListaPersonas();

}
