

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class InstructionTest.
 *
 * @author  Daniel
 * @version (a version number or a date)
 */
public class InstructionTest
{
    /**
     * Default constructor for test class InstructionTest
     */
    public InstructionTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void testInstructionConstructor()
    {
        Instruction instruction = new Instruction();
        assertNotNull(instruction);
    }

    @Test
    public void testAddStep()
    {
        Instruction instruction = new Instruction();
        instruction.addStep("Mix ingredients");
        instruction.addStep("Bake for 30 minutes");
        
        String steps = instruction.getSteps();
        assertTrue(steps.contains("Mix ingredients"));
        assertTrue(steps.contains("Bake for 30 minutes"));
    }

    @Test
    public void testAddStepWithIndex()
    {
        Instruction instruction = new Instruction();
        instruction.addStep("First step");
        instruction.addStep("Third step");
        instruction.addStep("Second step", 1);
        
        String steps = instruction.getSteps();
        assertTrue(steps.contains("Second step"));
    }

    @Test
    public void testRemoveStep()
    {
        Instruction instruction = new Instruction();
        instruction.addStep("Step 1");
        instruction.addStep("Step 2");
        instruction.addStep("Step 3");
        
        instruction.removeStep(1);
        String steps = instruction.getSteps();
        assertFalse(steps.contains("Step 2"));
        assertTrue(steps.contains("Step 1"));
        assertTrue(steps.contains("Step 3"));
    }

    @Test
    public void testGetSteps()
    {
        Instruction instruction = new Instruction();
        instruction.addStep("Preheat oven");
        instruction.addStep("Mix ingredients");
        instruction.addStep("Bake");
        
        String steps = instruction.getSteps();
        assertTrue(steps.contains("Preheat oven"));
        assertTrue(steps.contains("Mix ingredients"));
        assertTrue(steps.contains("Bake"));
    }

    @Test
    public void testMultipleSteps()
    {
        Instruction instruction = new Instruction();
        instruction.addStep("Step 1");
        instruction.addStep("Step 2");
        instruction.addStep("Step 3");
        instruction.addStep("Step 4");
        
        String steps = instruction.getSteps();
        assertTrue(steps.contains("1."));
        assertTrue(steps.contains("2."));
        assertTrue(steps.contains("3."));
        assertTrue(steps.contains("4."));
    }
}
