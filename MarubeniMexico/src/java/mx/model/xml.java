/*    */ package mx.model;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class xml implements Serializable {
/*    */   private String xml;
/*    */   private String uuid;
/*    */   private int estatus;
/*    */   private String observacion;
/*    */   private int bandera;
           private String numerosat;
           private String numerousuario;
/*    */   /*    */   
/*    */   public xml() {}
/*    */   /*    */   
/*    */   public xml(String xml) {
/* 15 */     this.xml = xml;
/*    */   }
/*    */   /*    */   
/*    */   public xml(String xml, String uuid, int estatus, String observacion, int bandera,String numerosat,String numerousuario) {
/* 19 */     this.xml = xml;
/* 20 */     this.uuid = uuid;
/* 21 */     this.estatus = estatus;
/* 22 */     this.observacion = observacion;
/* 23 */     this.bandera = bandera;
             this.numerosat = numerosat;
             this.numerousuario = numerousuario;
/*    */   }
/*    */   

            public void setxml(String xml){
                this.xml = xml;
            }
            
            public void setuuid(String uuid){
                this.uuid = uuid;
            }
            
            public void setestatus(int estatus){
                this.estatus = estatus;
            }
            
            public void setobservacion(String observacion){
                this.observacion = observacion;
            }
            
            public void setbandera(int bandera){
                this.bandera = bandera;
            }
            
            public void setnumerosat(String numerosat){
                this.numerosat = numerosat;
            }
            
            public void setnumerousuario(String numerousu){
                this.numerousuario = numerousu;
            }
            
            public String getxml(){
                return this.xml;
            }
            
            public String getuuid(){
                return this.uuid;
            }
            
            public int getEstatus(){
               return this.estatus;
            }
            public String getobservacion(){
                return this.observacion;
            }
            
            public int getbandera(){
                return this.bandera;
            }
            
            public String getnumerosat(){
                return this.numerosat;
            }
            
            public String getnumerousuario(){
                return this.numerousuario;
            }
/*    */  
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\model\Bancos.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */