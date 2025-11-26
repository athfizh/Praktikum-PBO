package com.polinema.kalkulator;

import com.formdev.flatlaf.FlatLightLaf;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * Modern Scientific Calculator Application
 * Features:
 * - Dynamic UI (Responsive Fonts, Resizable Layout)
 * - Scientific functions (Trig, Log, Exp)
 * - Degree/Radian support
 * - History panel (Resizable)
 * - Full Keyboard Support
 */
public class Kalkulator extends JFrame {

    private JTextField displayField;
    private DefaultListModel<String> historyModel;
    private JList<String> historyList;
    private boolean isResultDisplayed = false;
    private boolean isDegreeMode = true; // Default to Degrees
    private JButton degRadBtn;

    // Map to store buttons for visual feedback and scaling
    private Map<String, JButton> buttonMap = new HashMap<>();
    private JPanel buttonPanel;

    // Colors
    private final Color BG_COLOR = new Color(243, 244, 246); // Light Gray
    private final Color DISPLAY_BG = new Color(255, 255, 255);
    private final Color BTN_NUM_BG = new Color(255, 255, 255);
    private final Color BTN_OP_BG = new Color(224, 231, 255); // Light Indigo
    private final Color BTN_ACTION_BG = new Color(254, 226, 226); // Light Red
    private final Color BTN_EQUAL_BG = new Color(79, 70, 229); // Indigo
    private final Color TEXT_DARK = new Color(31, 41, 55);
    private final Color TEXT_WHITE = new Color(255, 255, 255);

    public Kalkulator() {
        initComponents();
        setupKeyBindings();
        setupResponsiveScaling();
    }

    private void initComponents() {
        setTitle("Kalkulator Scientific Modern");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setMinimumSize(new Dimension(600, 400)); // Prevent too small
        setLocationRelativeTo(null);

        // Main Container
        JPanel mainContainer = new JPanel(new BorderLayout());
        mainContainer.setBackground(BG_COLOR);

        // --- Top Panel: Display & Mode ---
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(BG_COLOR);
        topPanel.setBorder(new EmptyBorder(10, 20, 10, 20));

        // Mode Indicator / Toggle
        JPanel modePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        modePanel.setBackground(BG_COLOR);
        degRadBtn = new JButton("DEG");
        degRadBtn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        degRadBtn.setBackground(BTN_OP_BG);
        degRadBtn.setForeground(TEXT_DARK);
        degRadBtn.setFocusPainted(false);
        degRadBtn.setFocusable(false); // Prevent focus stealing
        degRadBtn.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        degRadBtn.addActionListener(e -> toggleDegRad());
        modePanel.add(degRadBtn);
        topPanel.add(modePanel, BorderLayout.NORTH);

        // Display Field
        displayField = new JTextField("");
        displayField.setFont(new Font("Segoe UI", Font.BOLD, 32));
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setEditable(false);
        displayField.setFocusable(true); // Allow focus for cursor navigation
        displayField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                displayField.getCaret().setVisible(true);
            }
        });
        displayField.setBackground(DISPLAY_BG);
        displayField.setForeground(TEXT_DARK);
        displayField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(229, 231, 235), 1),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        topPanel.add(displayField, BorderLayout.CENTER);

        mainContainer.add(topPanel, BorderLayout.NORTH);

        // --- Center: Buttons (Left) & History (Right) in SplitPane ---

        // Button Panel
        buttonPanel = new JPanel();
        buttonPanel.setBackground(BG_COLOR);
        buttonPanel.setLayout(new GridLayout(6, 5, 10, 10));
        buttonPanel.setBorder(new EmptyBorder(10, 20, 20, 10));

        String[] buttons = {
                "C", "DEL", "(", ")", "%",
                "sin", "cos", "tan", "log", "ln",
                "7", "8", "9", "/", "sqrt",
                "4", "5", "6", "*", "^",
                "1", "2", "3", "-", "pi",
                "0", ".", "+/-", "+", "="
        };

        for (String text : buttons) {
            JButton btn = createButton(text);
            buttonPanel.add(btn);
            buttonMap.put(text, btn);
        }

        // History Panel
        JPanel historyPanel = new JPanel(new BorderLayout());
        historyPanel.setBackground(DISPLAY_BG);
        historyPanel.setBorder(BorderFactory.createLineBorder(new Color(229, 231, 235), 1));

        JLabel historyLabel = new JLabel("History");
        historyLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        historyLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
        historyPanel.add(historyLabel, BorderLayout.NORTH);

        historyModel = new DefaultListModel<>();
        historyList = new JList<>(historyModel);
        historyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        historyList.setFocusable(false); // Prevent focus stealing
        historyList.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        historyList.setFixedCellHeight(30);
        historyList.setBorder(new EmptyBorder(5, 5, 5, 5));

        historyList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    String selected = historyList.getSelectedValue();
                    if (selected != null) {
                        String[] parts = selected.split(" = ");
                        if (parts.length > 0) {
                            displayField.setText(parts[0]);
                            isResultDisplayed = false;
                        }
                    }
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(historyList);
        scrollPane.setBorder(null);
        historyPanel.add(scrollPane, BorderLayout.CENTER);

        JButton clearHistoryBtn = new JButton("Clear History");
        clearHistoryBtn.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        clearHistoryBtn.setBackground(BTN_ACTION_BG);
        clearHistoryBtn.setForeground(Color.RED);
        clearHistoryBtn.setFocusPainted(false);
        clearHistoryBtn.setFocusable(false); // Prevent focus stealing
        clearHistoryBtn.addActionListener(e -> historyModel.clear());
        historyPanel.add(clearHistoryBtn, BorderLayout.SOUTH);

        // Split Pane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, buttonPanel, historyPanel);
        splitPane.setResizeWeight(0.75); // Buttons take 75% space
        splitPane.setDividerSize(5);
        splitPane.setBorder(null);
        splitPane.setBackground(BG_COLOR);

        mainContainer.add(splitPane, BorderLayout.CENTER);

        setContentPane(mainContainer);

        // Set Default Button for Enter key
        getRootPane().setDefaultButton(buttonMap.get("="));
    }

    private JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn.setFocusable(false); // Prevent focus to ensure keyboard input works globally
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Styling
        if (text.equals("=")) {
            btn.setBackground(BTN_EQUAL_BG);
            btn.setForeground(TEXT_WHITE);
        } else if (text.matches("[0-9]") || text.equals(".")) {
            btn.setBackground(BTN_NUM_BG);
            btn.setForeground(TEXT_DARK);
        } else if (text.matches("[/\\*\\-\\+]") || text.matches("sin|cos|tan|log|ln|sqrt|\\^|\\(|\\)|%|pi")) {
            btn.setBackground(BTN_OP_BG);
            btn.setForeground(new Color(67, 56, 202)); // Darker Indigo
        } else if (text.equals("C") || text.equals("DEL")) {
            btn.setBackground(BTN_ACTION_BG);
            btn.setForeground(new Color(185, 28, 28)); // Darker Red
        } else {
            btn.setBackground(BTN_NUM_BG);
            btn.setForeground(TEXT_DARK);
        }

        // Hover effect
        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                if (!text.equals("=")) {
                    btn.setBackground(btn.getBackground().darker());
                }
            }

            public void mouseExited(MouseEvent evt) {
                if (text.equals("=")) {
                    btn.setBackground(BTN_EQUAL_BG);
                } else if (text.matches("[0-9]") || text.equals(".")) {
                    btn.setBackground(BTN_NUM_BG);
                } else if (text.matches("[/\\*\\-\\+]") || text.matches("sin|cos|tan|log|ln|sqrt|\\^|\\(|\\)|%|pi")) {
                    btn.setBackground(BTN_OP_BG);
                } else if (text.equals("C") || text.equals("DEL")) {
                    btn.setBackground(BTN_ACTION_BG);
                } else {
                    btn.setBackground(BTN_NUM_BG);
                }
            }
        });

        btn.addActionListener(e -> onButtonClick(text));
        return btn;
    }

    private void setupKeyBindings() {
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getRootPane().getActionMap();

        // Also bind to displayField when it has focus
        InputMap displayInputMap = displayField.getInputMap(JComponent.WHEN_FOCUSED);
        ActionMap displayActionMap = displayField.getActionMap();

        // Digits
        for (int i = 0; i <= 9; i++) {
            String key = String.valueOf(i);
            inputMap.put(KeyStroke.getKeyStroke(Character.forDigit(i, 10)), key);
            inputMap.put(KeyStroke.getKeyStroke("NUMPAD" + i), key);

            displayInputMap.put(KeyStroke.getKeyStroke(Character.forDigit(i, 10)), key);
            displayInputMap.put(KeyStroke.getKeyStroke("NUMPAD" + i), key);

            actionMap.put(key, new ButtonAction(key));
            displayActionMap.put(key, new ButtonAction(key));
        }

        // Operators
        mapAction(inputMap, actionMap, displayInputMap, displayActionMap, "+", KeyEvent.VK_ADD); // Numpad +

        KeyStroke shiftEquals = KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, KeyEvent.SHIFT_DOWN_MASK);
        inputMap.put(shiftEquals, "+");
        displayInputMap.put(shiftEquals, "+");

        actionMap.put("+", new ButtonAction("+"));
        displayActionMap.put("+", new ButtonAction("+"));

        mapAction(inputMap, actionMap, displayInputMap, displayActionMap, "-", KeyEvent.VK_SUBTRACT, KeyEvent.VK_MINUS);
        mapAction(inputMap, actionMap, displayInputMap, displayActionMap, "*", KeyEvent.VK_MULTIPLY);

        KeyStroke shift8 = KeyStroke.getKeyStroke(KeyEvent.VK_8, KeyEvent.SHIFT_DOWN_MASK);
        inputMap.put(shift8, "*");
        displayInputMap.put(shift8, "*");

        mapAction(inputMap, actionMap, displayInputMap, displayActionMap, "/", KeyEvent.VK_DIVIDE, KeyEvent.VK_SLASH);
        mapAction(inputMap, actionMap, displayInputMap, displayActionMap, ".", KeyEvent.VK_DECIMAL, KeyEvent.VK_PERIOD);

        // Enter / Equals
        KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        KeyStroke equals = KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, 0);

        inputMap.put(enter, "=");
        inputMap.put(equals, "=");
        displayInputMap.put(enter, "=");
        displayInputMap.put(equals, "=");

        actionMap.put("=", new ButtonAction("="));
        displayActionMap.put("=", new ButtonAction("="));

        // Backspace / Delete
        KeyStroke backspace = KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0);
        KeyStroke delete = KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0);

        inputMap.put(backspace, "DEL");
        inputMap.put(delete, "DEL");
        displayInputMap.put(backspace, "DEL");
        displayInputMap.put(delete, "DEL");

        actionMap.put("DEL", new ButtonAction("DEL"));
        displayActionMap.put("DEL", new ButtonAction("DEL"));

        // Escape / Clear
        KeyStroke escape = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
        inputMap.put(escape, "C");
        displayInputMap.put(escape, "C");

        actionMap.put("C", new ButtonAction("C"));
        displayActionMap.put("C", new ButtonAction("C"));

        // Parentheses
        KeyStroke shift9 = KeyStroke.getKeyStroke(KeyEvent.VK_9, KeyEvent.SHIFT_DOWN_MASK);
        inputMap.put(shift9, "(");
        displayInputMap.put(shift9, "(");

        actionMap.put("(", new ButtonAction("("));
        displayActionMap.put("(", new ButtonAction("("));

        KeyStroke shift0 = KeyStroke.getKeyStroke(KeyEvent.VK_0, KeyEvent.SHIFT_DOWN_MASK);
        inputMap.put(shift0, ")");
        displayInputMap.put(shift0, ")");

        actionMap.put(")", new ButtonAction(")"));
        displayActionMap.put(")", new ButtonAction(")"));

        // Caret ^
        KeyStroke shift6 = KeyStroke.getKeyStroke(KeyEvent.VK_6, KeyEvent.SHIFT_DOWN_MASK);
        inputMap.put(shift6, "^");
        displayInputMap.put(shift6, "^");

        actionMap.put("^", new ButtonAction("^"));
        displayActionMap.put("^", new ButtonAction("^"));

        // Percent %
        KeyStroke shift5 = KeyStroke.getKeyStroke(KeyEvent.VK_5, KeyEvent.SHIFT_DOWN_MASK);
        inputMap.put(shift5, "%");
        displayInputMap.put(shift5, "%");

        actionMap.put("%", new ButtonAction("%"));
        displayActionMap.put("%", new ButtonAction("%"));
    }

    private void mapAction(InputMap inputMap, ActionMap actionMap, InputMap displayInputMap, ActionMap displayActionMap,
            String key, int... keyCodes) {
        for (int code : keyCodes) {
            KeyStroke ks = KeyStroke.getKeyStroke(code, 0);
            inputMap.put(ks, key);
            displayInputMap.put(ks, key);
        }
        actionMap.put(key, new ButtonAction(key));
        displayActionMap.put(key, new ButtonAction(key));
    }

    private class ButtonAction extends AbstractAction {
        private String command;

        public ButtonAction(String command) {
            this.command = command;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            onButtonClick(command);
            visualFeedback(command);
        }
    }

    private void visualFeedback(String command) {
        JButton btn = buttonMap.get(command);
        if (btn != null) {
            Color originalColor = btn.getBackground();
            btn.setBackground(originalColor.darker());
            Timer timer = new Timer(100, evt -> btn.setBackground(originalColor));
            timer.setRepeats(false);
            timer.start();
        }
    }

    private void setupResponsiveScaling() {
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = getWidth();
                int height = getHeight();

                // Base font sizes
                int baseDisplayFont = 32;
                int baseButtonFont = 16;

                // Calculate scale factor based on diagonal or width
                // Simple scaling: width / 900 (base width)
                float scale = Math.max(0.7f, Math.min(2.0f, (float) width / 900.0f));

                int newDisplaySize = Math.round(baseDisplayFont * scale);
                int newButtonSize = Math.round(baseButtonFont * scale);

                displayField.setFont(new Font("Segoe UI", Font.BOLD, newDisplaySize));

                for (JButton btn : buttonMap.values()) {
                    btn.setFont(new Font("Segoe UI", Font.BOLD, newButtonSize));
                }

                revalidate();
                repaint();
            }
        });
    }

    private void toggleDegRad() {
        isDegreeMode = !isDegreeMode;
        degRadBtn.setText(isDegreeMode ? "DEG" : "RAD");
    }

    private void onButtonClick(String command) {
        if (isResultDisplayed) {
            if (command.matches("[0-9]") || command.equals(".") ||
                    command.equals("pi") || command.equals("e") ||
                    command.matches("sin|cos|tan|log|ln|sqrt|\\(")) {
                displayField.setText("");
            }
            isResultDisplayed = false;
        }

        switch (command) {
            case "C":
                displayField.setText("");
                displayField.requestFocusInWindow();
                break;
            case "DEL":
                String text = displayField.getText();
                int caretPos = displayField.getCaretPosition();
                if (caretPos > 0 && !text.isEmpty()) {
                    String prefix = text.substring(0, caretPos - 1);
                    String suffix = text.substring(caretPos);
                    displayField.setText(prefix + suffix);
                    displayField.setCaretPosition(caretPos - 1);
                }
                displayField.requestFocusInWindow();
                break;
            case "=":
                calculate();
                displayField.requestFocusInWindow();
                break;
            case "ln":
                insertAtCursor("log(");
                break;
            case "log":
                insertAtCursor("log10(");
                break;
            case "sqrt":
                insertAtCursor("sqrt(");
                break;
            case "sin":
            case "cos":
            case "tan":
                insertAtCursor(command + "(");
                break;
            case "+/-":
                handleNegation();
                break;
            default:
                insertAtCursor(command);
                break;
        }
    }

    private void insertAtCursor(String text) {
        if (isResultDisplayed) {
            if (text.matches("[0-9]") || text.equals(".") ||
                    text.equals("pi") || text.equals("e") ||
                    text.matches("sin|cos|tan|log|ln|sqrt|\\(")) {
                displayField.setText("");
            }
            isResultDisplayed = false;
        }

        String currentText = displayField.getText();
        int caretPos = displayField.getCaretPosition();

        String prefix = currentText.substring(0, caretPos);
        String suffix = currentText.substring(caretPos);

        displayField.setText(prefix + text + suffix);
        displayField.setCaretPosition(caretPos + text.length());
        displayField.requestFocusInWindow();
    }

    private void handleNegation() {
        String text = displayField.getText();
        if (text.isEmpty()) {
            displayField.setText("-");
            return;
        }

        // Find the start of the last number
        int i = text.length() - 1;
        while (i >= 0) {
            char c = text.charAt(i);
            if (Character.isDigit(c) || c == '.') {
                i--;
            } else {
                break;
            }
        }

        // Insert '-' before the number
        String prefix = text.substring(0, i + 1);
        String suffix = text.substring(i + 1);
        displayField.setText(prefix + "-" + suffix);
    }

    private void calculate() {
        String expressionText = displayField.getText();
        if (expressionText.isEmpty())
            return;

        try {
            // Handle Percentage: Replace % with /100
            String finalExpression = expressionText.replace("%", "/100");

            ExpressionBuilder builder = new ExpressionBuilder(finalExpression);

            if (isDegreeMode) {
                finalExpression = finalExpression
                        .replace("sin", "sind")
                        .replace("cos", "cosd")
                        .replace("tan", "tand");

                builder = new ExpressionBuilder(finalExpression);

                builder.function(new net.objecthunter.exp4j.function.Function("sind", 1) {
                    @Override
                    public double apply(double... args) {
                        return Math.sin(Math.toRadians(args[0]));
                    }
                });
                builder.function(new net.objecthunter.exp4j.function.Function("cosd", 1) {
                    @Override
                    public double apply(double... args) {
                        return Math.cos(Math.toRadians(args[0]));
                    }
                });
                builder.function(new net.objecthunter.exp4j.function.Function("tand", 1) {
                    @Override
                    public double apply(double... args) {
                        return Math.tan(Math.toRadians(args[0]));
                    }
                });
            }

            Expression expression = builder.build();
            double result = expression.evaluate();

            String resultStr;
            if (result == (long) result) {
                resultStr = String.format("%d", (long) result);
            } else {
                resultStr = String.valueOf(result);
            }

            historyModel.addElement(expressionText + " = " + resultStr);
            displayField.setText(resultStr);
            isResultDisplayed = true;
        } catch (Exception e) {
            displayField.setText("Error");
            isResultDisplayed = true;
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            UIManager.put("Button.arc", 15);
            UIManager.put("Component.arc", 15);
            UIManager.put("TextComponent.arc", 15);
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            new Kalkulator().setVisible(true);
        });
    }
}
