package DiagnosticoApp;


/**
* DiagnosticoApp/DiagnosticoOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from diagnosticoApp.idl
* lunes 20 de mayo de 2019 03:48:05 PM COT
*/

public interface DiagnosticoOperations 
{
  boolean insertarDiagnostico (int id, String nombre, String descripcion, int id_paciente);
  String consultarDiagnostico (int id);
  boolean actualizarDiagnostico (int id, String nombre, String descripcion, int id_paciente);
  boolean eliminarDiagnostico (int id);
  String listarDiagnostico ();
  void shutdown ();
} // interface DiagnosticoOperations
