package leandro.ds.graph;

import java.util.*;

import org.springframework.stereotype.Component;

@Component
public class Graph {
    private Map<String, List<String>> nearest;

    public Graph() {
        nearest = new HashMap<>();
    }

    public void addRoot(String destination, String nearest) {
        this.nearest.putIfAbsent(destination, new ArrayList<>());
        this.nearest.putIfAbsent(nearest, new ArrayList<>());
        this.nearest.get(destination).add(nearest);
        this.nearest.get(nearest).add(destination);
    }

    public List<String> getCommonNearest(String destination1, String destination2) {
        List<String> commonNearest = new ArrayList<>();

        if (nearest.containsKey(destination1) && nearest.containsKey(destination2)) {
            List<String> nearestDestination1 = nearest.get(destination1);
            List<String> nearestDestination2 = nearest.get(destination2);

            for (String nearest : nearestDestination1) {
                if (nearestDestination2.contains(nearest)) {
                    commonNearest.add(nearest);
                }
            }
        }

        return commonNearest;
    }

    public List<String> findShorterWay(String destination1, String destination2) {
        if (!nearest.containsKey(destination1) || !nearest.containsKey(destination2)) {
            return null;
        }

        Map<String, String> predecessores = new HashMap<>();
        Queue<String> fila = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        fila.offer(destination1);
        visited.add(destination1);

        while (!fila.isEmpty()) {
            String destinationCurrent = fila.poll();

            if (destinationCurrent.equals(destination2)) {
                break;
            }

            List<String> nearestDestination = nearest.get(destinationCurrent);

            for (String nearest : nearestDestination) {
                if (!visited.contains(nearest)) {
                    fila.offer(nearest);
                    visited.add(nearest);
                    predecessores.put(nearest, destinationCurrent);
                }
            }
        }

        if (!visited.contains(destination2)) {
            return null;
        }

        List<String> way = new ArrayList<>();
        String destination = destination2;

        while (destination != null) {
            way.add(destination);
            destination = predecessores.get(destination);
        }

        Collections.reverse(way);

        return way;
    }

    public List<String> getDestinations() {
        return new ArrayList<>(nearest.keySet());
    }
}

