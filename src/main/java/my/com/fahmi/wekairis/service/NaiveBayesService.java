package my.com.fahmi.wekairis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import weka.classifiers.Classifier;
import weka.core.DenseInstance;
import weka.core.Instances;
import weka.core.converters.CSVLoader;

import java.io.IOException;
import java.io.ObjectInputStream;

@Service
public class NaiveBayesService {

    private static final Logger logger = LoggerFactory.getLogger(NaiveBayesService.class.getName());

    private Classifier model;

    public NaiveBayesService() {
        try (ObjectInputStream ois = new ObjectInputStream(getClass().getClassLoader().getResourceAsStream("iris.model"))) {
            model = (Classifier) ois.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public double classifyInstance(double[] featureValues) throws Exception {
        // Use the corrected approach to load iris.csv
        ClassPathResource resource = new ClassPathResource("iris.csv");
        if (!resource.exists()) {
            logger.error("Iris dataset file not found.");
            throw new RuntimeException("Iris dataset file not found in classpath.");
        }

        // Create an instance structure based on the dataset
        CSVLoader csvLoader = new CSVLoader();
        csvLoader.setSource(resource.getInputStream());
        Instances structure = csvLoader.getDataSet();
        structure.setClassIndex(structure.numAttributes() - 1);


        // Create a new instance and set its feature values
        DenseInstance newInstance = new DenseInstance(featureValues.length + 1);
        for (int i = 0; i < featureValues.length; i++) {
            newInstance.setValue(i, featureValues[i]);
        }
        newInstance.setDataset(structure);

        // Classify the new instance and return the result
        return model.classifyInstance(newInstance);
    }
}
