import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class Table_custom extends JFrame {
    
    public Table_custom() {
        // Data untuk JTable
        String[][] data = {
                {"101", "Alice", "18", "A"},
                {"102", "Bob", "19", "B"},
                {"103", "Carol", "20", "A"},
                {"104", "David", "21", "C"}
        };

        // Nama Kolom
        String[] columnNames = {"ID", "Name", "Age", "Grade"};

        // Model Tabel
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Membuat JTable
        JTable table = new JTable(model) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                
                // Warna background baris (zebra stripes)
                if (!isRowSelected(row)) {
                    c.setBackground(row % 2 == 0 ? new Color(220, 220, 220) : Color.WHITE);
                } else {
                    c.setBackground(new Color(184, 207, 229)); // Warna saat dipilih
                }
                return c;
            }
        };

        // Custom header
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("SansSerif", Font.BOLD, 16));
        header.setBackground(new Color(72, 81, 84)); // Warna header
        header.setForeground(Color.WHITE); // Warna teks header

        // Mengatur ukuran kolom
        table.setRowHeight(25);
        table.setFont(new Font("Arial", Font.PLAIN, 14)); // Set font tabel
        table.setGridColor(Color.LIGHT_GRAY); // Warna grid
        
        // Scroll Pane
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);

        // Pengaturan JFrame
        this.setTitle("Custom JTable Example");
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Table_custom());
    }
}
