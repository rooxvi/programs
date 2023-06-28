package io.ravi.fileprocessing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;
import java.util.stream.Collectors;

//Ref: https://www.thetechnojournals.com/2019/10/how-to-read-large-file-in-java.html

public class FileProcessing {

    private final long mb = 1024*1024;
    private final String file = "/Users/Downloads/sample.csv";


   // @EventListener(ApplicationReadyEvent.class)
    public void testLargeFile() throws Exception{
        long premem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long start = System.currentTimeMillis();

        System.out.println("Used memory pre run (MB): "+(premem/mb));
        //PLEASE UNCOMMENT THE 1 LINE OUT OF BELOW 2 LINES AT A TIME TO TEST
        //THE DESIRED FUNCTIONALITY
//        System.out.println("Year count: "+simpleYearCount(file));//process file synchronously and print details
//        System.out.println("Year count: "+asyncYearCount(file));//process file asynchronously and print details

        long postmem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();

        System.out.println("Used memory post run (MB): "+(postmem/mb));
        System.out.println("Memory consumed (MB): "+(postmem-premem)/mb);
        System.out.println("Time taken in MS: "+(System.currentTimeMillis()-start));
    }

    public Map<String, Integer> asyncYearCount(String file) throws IOException, InterruptedException, ExecutionException {
        try {
            List<CompletableFuture<Map<String, Integer>>> futures = new ArrayList<>();

            List<String> items = new ArrayList<>();
            Files.lines(Paths.get(file))
                    .skip(1)//skip first line
                    .forEach(line->{
                        items.add(line);
                        if(items.size()%10000==0) {
                            //add completable task for each of 10000 rows
                            futures.add(CompletableFuture.supplyAsync(yearCountSupplier(new ArrayList<>(items), new HashMap<>())));
                            items.clear();
                        }
                    });
            if(items.size()>0) {
                //add completable task for remaining rows
                futures.add(CompletableFuture.supplyAsync(yearCountSupplier(items, new HashMap<>())));
            }
            return CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]))
                    .thenApply($->{
                        //join all task to collect result after all tasks completed
                        return futures.stream().map(ftr->ftr.join()).collect(Collectors.toList());
                    })
                    .thenApply(maps->{
                        Map<String, Integer> yearCountMap = new HashMap<>();
                        maps.forEach(map->{
                            //merge the result of all the tasks
                            map.forEach((key, val)->{
                                if(yearCountMap.containsKey(key)) {
                                    yearCountMap.put(key, yearCountMap.get(key)+val);
                                }else
                                    yearCountMap.put(key, val);
                            });
                        });
                        return yearCountMap;
                    })
                    .get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }

    //Supplier method to count the year in given rows
    public Supplier<Map<String, Integer>> yearCountSupplier(List<String> items, Map<String, Integer> map){
        return ()->{
            items.forEach((line)->{
                yearCount(line,map);
            });
            return map;
        };
    }

    public Map<String, Integer> simpleYearCount(String file) throws IOException {
        Map<String, Integer> yearCountMap = new HashMap<>();

        Files.lines(Paths.get(file))
                .skip(1)//skip first line
                .forEach((s)->{
                    yearCount(s, yearCountMap);
                });

        return yearCountMap;
    }

    public void yearCount(String line, Map<String, Integer> countMap){
        String key = line.substring(1, 5);
        if(countMap.containsKey(key)) {
            countMap.put(key, countMap.get(key)+1);
        }else
            countMap.put(key, 1);
    }
}


/**
 * Synchronous processing:
 * Used memory pre run (MB): 41
 * Year count: {2019=1178560, 2018=2775136, 2017=559632, 2016=250144, 2015=248192, 2014=144656}
 * Used memory post run (MB): 304
 * Memory consumed (MB): 262
 * Time taken in MS: 1971
 */

/**
 * Asynchronous processing:
 * Used memory pre run (MB): 120
 * Year count: {2019=1178560, 2018=2775136, 2017=559632, 2016=250144, 2015=248192, 2014=144656}
 * Used memory post run (MB): 262
 * Memory consumed (MB): 142
 * Time taken in MS: 1549
 */