package my.com.fahmi.wekairis.controller;

import my.com.fahmi.wekairis.service.NaiveBayesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PredictionController {

    private final NaiveBayesService naiveBayesService;

    public PredictionController(NaiveBayesService naiveBayesService) {
        this.naiveBayesService = naiveBayesService;
    }

    @PostMapping("/predict")
    public ResponseEntity<Object> predict(@RequestBody double[] featureValues) {
        try {
            double prediction = naiveBayesService.classifyInstance(featureValues);
            return ResponseEntity.ok(prediction);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
        }
    }
}
