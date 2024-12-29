package com.mediplants.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mediplants.app.entities.Plant;
import com.mediplants.app.repositories.PlantRepository;

@SpringBootApplication
public class MediPlantsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediPlantsApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(PlantRepository plantRepository) {
        return args -> {
            plantRepository.save(new Plant(null, "Aloe Vera", "Succulent plant", "Soothing", "Skin care", "Avoid excess use", "May interact with medication", "Tropical", "Medicinal"));
            plantRepository.save(new Plant(null, "Basil", "Herb", "Anti-inflammatory", "Cooking", "No known precautions", "None", "Worldwide", "Culinary"));
            plantRepository.save(new Plant(null, "Chamomile", "Flowering plant", "Calming", "Tea", "May cause allergies", "None", "Temperate", "Herbal"));
            plantRepository.save(new Plant(null, "Lavender", "Fragrant flower", "Relaxing", "Aromatherapy", "Avoid oral consumption", "None", "Mediterranean", "Aromatic"));
            plantRepository.save(new Plant(null, "Mint", "Herb", "Refreshing", "Tea and cooking", "Overuse may cause nausea", "None", "Global", "Culinary"));
            plantRepository.save(new Plant(null, "Rosemary", "Evergreen shrub", "Improves memory", "Cooking", "Avoid during pregnancy", "None", "Mediterranean", "Aromatic"));
            plantRepository.save(new Plant(null, "Sage", "Herb", "Anti-inflammatory", "Cooking", "Avoid in high doses", "May interact with medication", "Mediterranean", "Culinary"));
            plantRepository.save(new Plant(null, "Thyme", "Herb", "Antimicrobial", "Cooking", "None", "None", "Global", "Culinary"));
            plantRepository.save(new Plant(null, "Turmeric", "Root plant", "Anti-inflammatory", "Spice", "Avoid in large doses", "None", "Tropical", "Medicinal"));
            plantRepository.save(new Plant(null, "Echinacea", "Flowering plant", "Immune boosting", "Tea", "May cause allergies", "None", "Temperate", "Herbal"));

            plantRepository.save(new Plant(null, "Ginger", "Root plant", "Digestive aid", "Cooking and tea", "Avoid excess use", "None", "Tropical", "Medicinal"));
            plantRepository.save(new Plant(null, "Garlic", "Bulb plant", "Antimicrobial", "Cooking", "Avoid excess raw consumption", "May thin blood", "Global", "Culinary"));
            plantRepository.save(new Plant(null, "Dandelion", "Flowering plant", "Detoxifying", "Tea", "May cause allergies", "None", "Temperate", "Herbal"));
            plantRepository.save(new Plant(null, "Peppermint", "Herb", "Cooling", "Tea and essential oil", "Avoid during pregnancy", "None", "Global", "Aromatic"));
            plantRepository.save(new Plant(null, "Neem", "Tree", "Antibacterial", "Skin care", "Avoid oral use", "None", "Tropical", "Medicinal"));
            plantRepository.save(new Plant(null, "Ashwagandha", "Root plant", "Stress relief", "Supplements", "Avoid during pregnancy", "None", "India", "Herbal"));
            plantRepository.save(new Plant(null, "Holy Basil", "Herb", "Adaptogenic", "Tea and supplements", "None", "None", "India", "Herbal"));
            plantRepository.save(new Plant(null, "Parsley", "Herb", "Rich in vitamins", "Cooking", "Avoid large amounts", "None", "Global", "Culinary"));
            plantRepository.save(new Plant(null, "Fenugreek", "Seed plant", "Lactation aid", "Cooking and supplements", "May lower blood sugar", "None", "India", "Herbal"));
            plantRepository.save(new Plant(null, "Cinnamon", "Bark", "Blood sugar control", "Spice", "Avoid in large doses", "None", "Tropical", "Culinary"));

            plantRepository.save(new Plant(null, "Amla", "Fruit plant", "Vitamin C rich", "Supplements", "None", "None", "India", "Herbal"));
            plantRepository.save(new Plant(null, "Coriander", "Herb", "Digestive aid", "Cooking", "None", "None", "Global", "Culinary"));
            plantRepository.save(new Plant(null, "Cardamom", "Seed plant", "Aromatic", "Cooking and tea", "None", "None", "Tropical", "Aromatic"));
            plantRepository.save(new Plant(null, "Clove", "Flower bud", "Pain relief", "Spice", "Avoid in high doses", "None", "Global", "Culinary"));
            plantRepository.save(new Plant(null, "Lemongrass", "Herb", "Calming", "Tea and oil", "None", "None", "Tropical", "Aromatic"));
            plantRepository.save(new Plant(null, "Licorice", "Root plant", "Soothing", "Supplements", "Avoid in high doses", "May raise blood pressure", "Temperate", "Medicinal"));
            plantRepository.save(new Plant(null, "Bay Leaf", "Leaf", "Aromatic", "Cooking", "Remove before eating", "None", "Mediterranean", "Aromatic"));
            plantRepository.save(new Plant(null, "Hibiscus", "Flowering plant", "Blood pressure control", "Tea", "Avoid during pregnancy", "None", "Tropical", "Herbal"));
            plantRepository.save(new Plant(null, "Black Pepper", "Seed plant", "Digestive aid", "Spice", "Avoid in large doses", "None", "Tropical", "Culinary"));
            plantRepository.save(new Plant(null, "Fennel", "Seed plant", "Digestive aid", "Tea and cooking", "None", "None", "Temperate", "Culinary"));

        };
    }
}
