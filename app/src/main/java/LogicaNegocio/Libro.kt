package LogicaNegocio;

import java.io.Serializable

data class Libro(val nombre:String, val editorial:String, val fecha:Int, val idioma:String, val tema:String, val precio: Int, val foto:String, val sinopsis:String):Serializable