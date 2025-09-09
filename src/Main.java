import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Indtast tid på dagen (dag, aften, nat): ");
        String timeOfDay = input.nextLine();

        System.out.print("Indtast trafikmængde (høj/lav): ");
        String traffic = input.nextLine();

        System.out.print("Indtast områdets type (bolig, erhverv, blandet): ");
        String areaType = input.nextLine();

        System.out.print("Er der en nødsituation? (ja/nej): ");
        String emergency = input.nextLine();

        // Trafiklys farvebetingelser
        String lightColor;
        if (timeOfDay.equalsIgnoreCase("dag") && traffic.equalsIgnoreCase("lav") || emergency.equals("ja")) {
            lightColor = "GRØNT - trafikken flyder fint!";
        } else if (timeOfDay.equalsIgnoreCase("aften") || timeOfDay.equalsIgnoreCase("nat") && traffic.equalsIgnoreCase("lav")) {
            lightColor = "GULT - trafikken stopper/starter snart!";
        } else if (timeOfDay.equalsIgnoreCase("nat") && traffic.equalsIgnoreCase("høj") || areaType.equalsIgnoreCase("bolig") && traffic.equalsIgnoreCase("høj")){
            lightColor = "RØDT - trafikken er stoppet!";
        } else {
            lightColor = "INGEN - Uden for logik farveregime";
        }

        // Adgangsbetingelser
        String access;
        if (areaType.equalsIgnoreCase("erhverv") || areaType.equalsIgnoreCase("blandet") && traffic.equalsIgnoreCase("lav")) {
            access = "TILLADT - kørsel i området er tilladt";
        } else if (areaType.equalsIgnoreCase("bolig") && timeOfDay.equalsIgnoreCase("nat")) {
            access = "FORBUDT - natlukning i området.";
        } else {
            access = "BEGRÆNSET - adgang afhænger af lokale regler";
        }

        System.out.println(); // Mellemrum mellem input & output

        System.out.println("\uD83D\uDEA6 Trafiklysstatus: " + lightColor);
        System.out.println("\uD83D\uDE97 Adgang: " + access);
    }
}