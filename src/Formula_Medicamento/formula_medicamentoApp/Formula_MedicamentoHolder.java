package formula_medicamentoApp;

/**
* formula_medicamentoApp/Formula_MedicamentoHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from formula_medicamentoApp.idl
* lunes 20 de mayo de 2019 03:49:12 PM COT
*/

public final class Formula_MedicamentoHolder implements org.omg.CORBA.portable.Streamable
{
  public formula_medicamentoApp.Formula_Medicamento value = null;

  public Formula_MedicamentoHolder ()
  {
  }

  public Formula_MedicamentoHolder (formula_medicamentoApp.Formula_Medicamento initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = formula_medicamentoApp.Formula_MedicamentoHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    formula_medicamentoApp.Formula_MedicamentoHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return formula_medicamentoApp.Formula_MedicamentoHelper.type ();
  }

}