public class Program2 { 
    public static void main(String[] args) {
        Rektor pakRektor = new Rektor();
        
        Sarjana sarjanaCumlaude = new Sarjana("Dini"); 
        PascaSarjana masterCumlaude = new PascaSarjana("Elok");

        System.out.println("--- Pemberian Sertifikat CUMLAUDE ---");
        pakRektor.beriSertifikatCumlaude(sarjanaCumlaude);
        pakRektor.beriSertifikatCumlaude(masterCumlaude);

        System.out.println("--- Pemberian Sertifikat MAWAPRES ---");
        
        pakRektor.beriSertifikatMawapres(sarjanaCumlaude); 
        pakRektor.beriSertifikatMawapres(masterCumlaude);
    }
}