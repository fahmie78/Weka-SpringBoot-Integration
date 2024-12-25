# README.md

### Weka + Spring Boot Integration

This project demonstrates the integration of a machine learning model using the Weka Workbench and Spring Boot 3 to create a prediction API.  
The dataset used is the famous Iris dataset, and the classification model utilized is Naive Bayes.

### Steps to Follow

1. Download the Weka Workbench using `brew install weka` or from the official website: [Weka Workbench Download](https://waikato.github.io/weka-wiki/downloading_weka/).
2. Download the Iris dataset from [Kaggle](https://www.kaggle.com/datasets/himanshunakrani/iris-dataset?resource=download).
3. Load the dataset (`iris.csv`) into the Weka Workbench using the **Preprocess** tab.
4. Navigate to the **Classify** tab.
5. Choose **NaiveBayes** as the classifier.
6. Select **species** as the target attribute (class).
7. Press the **Start** button to train the model.
8. Once the model is trained, right-click on the results in the "Result list" section and choose **Save model** to save it as `iris.model`.
9. Copy both the trained model (`iris.model`) and the dataset (`iris.csv`) into the `resources` directory of the Spring Boot project.
10. Run the Spring Boot application.

#### Happy exploring and learning!