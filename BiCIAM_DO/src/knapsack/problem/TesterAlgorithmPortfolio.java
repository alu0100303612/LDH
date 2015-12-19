package knapsack.problem;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import local_search.complement.StopExecute;
import local_search.complement.UpdateParameter;
import metaheurictics.strategy.Strategy;
import metaheuristics.generators.DistributionEstimationAlgorithm;
import metaheuristics.generators.EvolutionStrategies;
import metaheuristics.generators.GeneratorType;
import metaheuristics.generators.GeneticAlgorithm;
import metaheuristics.generators.MultiGenerator;
import metaheuristics.generators.SimulatedAnnealing;

public class TesterAlgorithmPortfolio {
	
	public void configAlgorithmPortfolio() {
		// evolutionary strategy
		EvolutionStrategies.countRef = 50;
		EvolutionStrategies.truncation = 20;
		EvolutionStrategies.PM = 0.9;
	 	// genetic algorithm
		GeneticAlgorithm.countRef = 50;
		GeneticAlgorithm.truncation = 20;
		GeneticAlgorithm.PM = 0.5;
		GeneticAlgorithm.PC = 0.9;
		// univariate marginal distribution algorithm
		DistributionEstimationAlgorithm.countRef = 50;
		DistributionEstimationAlgorithm.truncation = 20;	
		// simulated annealing
		SimulatedAnnealing.alpha = 0.93;
    	SimulatedAnnealing.tinitial = 20.0;
    	SimulatedAnnealing.tfinal = 0.0;
    	SimulatedAnnealing.countIterationsT = 50;
	}
	
	public void executeAlgorithmPortfolio() throws IllegalArgumentException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, IOException {
		configAlgorithmPortfolio();
		int countmaxIterations = 0;
		int operatornumber = 1;
		Strategy.getStrategy().setStopexecute(new StopExecute());
		Strategy.getStrategy().setUpdateparameter(new UpdateParameter());
		//Strategy.getStrategy().executeStrategy(countmaxIterations, operatornumber, GeneratorType.MultiGenerator);
		Strategy.destroyExecute();
		MultiGenerator.destroyMultiGenerator();
	}

}