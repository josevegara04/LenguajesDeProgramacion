import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Main 
{
    public static void main(String[] args)
    {
        List<Ventas> ventasList = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader("datos.csv")))
        {
            ventasList = br.lines().skip(1)
                    .map(line -> 
                    {
                        String[] campos = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                        Ventas venta = new Ventas();
                        venta.setOrderNumber(campos[0]);
                        venta.setQuantityOrdered(Integer.parseInt(campos[1]));
                        venta.setPrice(Double.parseDouble(campos[2]));
                        venta.setOrderLineNumber(campos[3]);
                        venta.setSales(campos[4]);
                        venta.setOrderDate(campos[5]);
                        venta.setOrderStatus(campos[6]);
                        venta.setQTR_ID(campos[7]);
                        venta.setMonth_ID(campos[8]);
                        venta.setYear_ID(campos[9]);
                        venta.setProductLine(campos[10]);
                        venta.setMSRP(campos[11]);
                        venta.setProductCode(campos[12]);
                        venta.setCostumerName(campos[13]);
                        venta.setPhone(campos[14].isEmpty() ? "nulo" : campos[14]);
                        venta.setAdress1(campos[15].isEmpty() ? "nulo" : campos[15]);
                        venta.setAdress2(campos[16].isEmpty() ? "nulo" : campos[16]);
                        venta.setCity(campos[17].isEmpty() ? "nulo" : campos[17]);
                        venta.setState(campos[18].isEmpty() ? "nulo" : campos[18]);
                        venta.setPostalCode(campos[19].isEmpty() ? "nulo" : campos[19]);
                        venta.setContry(campos[20]);
                        venta.setTerritory(campos[21]);
                        venta.setContactLastName(campos[22]);
                        venta.setContactFirstName(campos[23]);
                        venta.setDealSize(campos[24]);
                        return venta;
                    }).toList();
        }
        catch (IOException e)
        {
            System.out.println("archivo no encontrado. Colocar el archivo datos.csv en la raiz" + e.getMessage());
        }
        int coleccionVentasNYC = ventasList.stream()
            .filter(venta -> venta.getCity().equals("NYC"))
            .mapToInt(Ventas::getQuantityOrdered)
            .sum();
        System.out.println("\nEL número de ordenes recibidas en Nueva York fue: " + coleccionVentasNYC + "\n");

        double totalVentas = ventasList.stream()
                    .filter(venta -> venta.getCity().equals("NYC"))
                    .mapToDouble(Ventas::getPrice)
                    .sum();
        System.out.println("El total de ventas en la ciudad de Nueva York fue: $" + totalVentas + "\n");

        long totalAutosNYC = ventasList.stream()
            .filter(venta -> venta.getCity().equals("NYC"))
            .filter(venta -> venta.getProductLine().equals("Classic Cars"))
            .count();
        System.out.println("El total de autos clásicos vendidos en la Ciudad de Nueva York fue: " + totalAutosNYC + "\n");

        double totalVentasAutosClasicosNYC = ventasList.stream()
            .filter(venta -> venta.getCity().equals("NYC"))
            .filter(venta -> venta.getProductLine().equals("Classic Cars"))
            .mapToDouble(Ventas::getPrice)
            .sum();
        System.out.println("El total de ventas de autos clásicos en la ciudad de Nueva York fue: $" + totalVentasAutosClasicosNYC + "\n");

        long totalMotocicletasNYC= ventasList.stream()
            .filter(venta -> venta.getCity().equals("NYC"))
            .filter(venta -> venta.getProductLine().equals("Motorcycles"))
            .count();
        System.out.println("El total de motocicletas vendidas en la Ciudad de Nueva York fue: " + totalMotocicletasNYC + "\n");

        double totalVentasMotocicletasNYC = ventasList.stream()
            .filter(venta -> venta.getCity().equals("NYC"))
            .filter(venta -> venta.getProductLine().equals("Motorcycles"))
            .mapToDouble(Ventas::getPrice)
            .sum();
        System.out.println("El total de ventas de motocicletas en la ciudad de Nueva York fue: $" + totalVentasMotocicletasNYC + "\n");

        String clienteAutos = ventasList.stream()
            .filter(venta -> venta.getCity().equals("NYC"))
            .filter(venta -> venta.getProductLine().equals("Classic Cars"))
            .max(Comparator.comparingInt(Ventas::getQuantityOrdered))
            .map(venta -> venta.getContactFirstName() + " " + venta.getContactLastName())
            .orElse("Ninguno");
        System.out.println("El cliente que mas autos compró en la ciudad de Nueva York fue: " + clienteAutos + "\n");

        String clienteQueMasCompro = ventasList.stream()
            .max(Comparator.comparingInt(Ventas::getQuantityOrdered))
            .map(venta -> venta.getContactFirstName() + " " + venta.getContactLastName())
            .orElse("Ninguno");
        System.out.println("El cliente que mas compró del archivo fue: " + clienteQueMasCompro + "\n");

        String clienteQueMenosCompro = ventasList.stream()
            .min(Comparator.comparingInt(Ventas::getQuantityOrdered))
            .map(venta -> venta.getContactFirstName() + " " + venta.getContactLastName())
            .orElse("Ninguno");
        System.out.println("El cliente que menos compró del archivo fue: " + clienteQueMenosCompro + "\n");
    }
}