package base;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameConsole {
    private final Simulation simulation;
    private final Map<String, Runnable> methodsMap;
    private Thread simulationThread ;
    private Thread inputThread;
    private boolean exit;

    GameConsole(){
        exit = false;
        this.simulation = new Simulation();
        System.out.println("Добро пожаловать в симуляцию\nВедите команду help, " +
                            "чтобы получить список доступных команд");
        simulation.getRenderer().render(simulation.getGameMap());
        methodsMap = new HashMap<>();
        methodsMap.put("step", simulation::nextTurn);
        methodsMap.put("start", this::startSimulationThread);
        methodsMap.put("stop", simulation::stopSimulation);
        methodsMap.put("exit", this::exit);
        methodsMap.put("help", this::help);
        startConsole();
    }

    public void startSimulationThread(){
        simulationThread = new Thread(simulation::startSimulation);
        simulationThread.start();
    }

    public void startConsole(){
        inputThread = new Thread(this::getInput);
        inputThread.start();
    }

    public void getInput(){
        Scanner scanner = new Scanner(System.in);
        while (!exit){
            String input = scanner.nextLine();
            if (methodsMap.containsKey(input)){
                methodsMap.get(input).run();
            }
        }
    }
    public void exit(){
        simulation.stopSimulation();
        exit = true;
    }

    public void help(){
        System.out.println("step - делает 1 шаг симуляции;");
        System.out.println("start - запускает бесконечный цикл симуляции;");
        System.out.println("stop - останавливает бесконечный цикл симуляции;");
        System.out.println("exit - выход из игры.");
    }
}
