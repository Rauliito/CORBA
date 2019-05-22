package DiagnosticoApp;


/**
* DiagnosticoApp/DiagnosticoPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from diagnosticoApp.idl
* lunes 20 de mayo de 2019 03:48:05 PM COT
*/

public abstract class DiagnosticoPOA extends org.omg.PortableServer.Servant
 implements DiagnosticoApp.DiagnosticoOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("insertarDiagnostico", new java.lang.Integer (0));
    _methods.put ("consultarDiagnostico", new java.lang.Integer (1));
    _methods.put ("actualizarDiagnostico", new java.lang.Integer (2));
    _methods.put ("eliminarDiagnostico", new java.lang.Integer (3));
    _methods.put ("listarDiagnostico", new java.lang.Integer (4));
    _methods.put ("shutdown", new java.lang.Integer (5));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // DiagnosticoApp/Diagnostico/insertarDiagnostico
       {
         int id = in.read_long ();
         String nombre = in.read_wstring ();
         String descripcion = in.read_wstring ();
         int id_paciente = in.read_long ();
         boolean $result = false;
         $result = this.insertarDiagnostico (id, nombre, descripcion, id_paciente);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // DiagnosticoApp/Diagnostico/consultarDiagnostico
       {
         int id = in.read_long ();
         String $result = null;
         $result = this.consultarDiagnostico (id);
         out = $rh.createReply();
         out.write_wstring ($result);
         break;
       }

       case 2:  // DiagnosticoApp/Diagnostico/actualizarDiagnostico
       {
         int id = in.read_long ();
         String nombre = in.read_wstring ();
         String descripcion = in.read_wstring ();
         int id_paciente = in.read_long ();
         boolean $result = false;
         $result = this.actualizarDiagnostico (id, nombre, descripcion, id_paciente);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 3:  // DiagnosticoApp/Diagnostico/eliminarDiagnostico
       {
         int id = in.read_long ();
         boolean $result = false;
         $result = this.eliminarDiagnostico (id);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 4:  // DiagnosticoApp/Diagnostico/listarDiagnostico
       {
         String $result = null;
         $result = this.listarDiagnostico ();
         out = $rh.createReply();
         out.write_wstring ($result);
         break;
       }

       case 5:  // DiagnosticoApp/Diagnostico/shutdown
       {
         this.shutdown ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:DiagnosticoApp/Diagnostico:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Diagnostico _this() 
  {
    return DiagnosticoHelper.narrow(
    super._this_object());
  }

  public Diagnostico _this(org.omg.CORBA.ORB orb) 
  {
    return DiagnosticoHelper.narrow(
    super._this_object(orb));
  }


} // class DiagnosticoPOA