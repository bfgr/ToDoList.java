import javax.swing.*;
import java.awt.*;

public class ToDoList {

    JFrame frame;
    JTextField taskField;
    DefaultListModel<String> taskModel;
    JList<String> taskList;

    public ToDoList() {

        frame = new JFrame("To-Do List");
        frame.setSize(500,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel taskLabel = new JLabel("Task:");

        taskField = new JTextField(20);

        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");
        JButton clearButton = new JButton("Clear All");

        taskModel = new DefaultListModel<>();

        taskList = new JList<>(taskModel);

        JScrollPane scrollPane =
                new JScrollPane(taskList);

        scrollPane.setPreferredSize(
                new Dimension(450,200)
        );

        addButton.addActionListener(
                e -> addTask()
        );

        removeButton.addActionListener(
                e -> removeTask()
        );

        clearButton.addActionListener(
                e -> taskModel.clear()
        );

        frame.add(taskLabel);
        frame.add(taskField);

        frame.add(addButton);
        frame.add(removeButton);
        frame.add(clearButton);

        frame.add(scrollPane);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void addTask() {

        String task = taskField.getText();

        if(task.isEmpty()) {

            JOptionPane.showMessageDialog(
                    frame,
                    "Enter a task!"
            );

            return;
        }

        taskModel.addElement(task);

        taskField.setText("");
    }

    private void removeTask() {

        int selected =
                taskList.getSelectedIndex();

        if(selected != -1) {

            taskModel.remove(selected);

        } else {

            JOptionPane.showMessageDialog(
                    frame,
                    "Select a task!"
            );
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->
                new ToDoList()
        );
    }
}