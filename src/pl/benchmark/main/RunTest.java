package pl.benchmark.main;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import pl.benchmark.testclass.TestClass;
import pl.benchmark.testclass.impl.TestClassImpl;


public class RunTest {

	public static final int COUNT_1 = 1000000;
	public static final int COUNT_2 = 10000000;
	public static final int COUNT_3 = 100000000;

	public static final int PRE_RUN = 1000000;


	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		//benFirst(new TestClassImpl());
		
		//benSecond(new TestClassImpl());
		
		benThird(new TestClassImpl());

	}

	//bezposredni dostep
	public static void benFirst(TestClassImpl test){
		//1. Odczyt
		//rozgrzewka
		for(int i = 0; i < PRE_RUN; i++){
			String ss = test.s;
			int ii = test.i;
		}

		System.out.println("-------------------------------------\n"
				+ "###  Dostep bezposredni do pol ###\n\n"
				+ "Publiczne - odczyt (" + COUNT_1 + " wywolan):");

		long startTime = System.currentTimeMillis();
		for(int i = 0; i < COUNT_1; i++){
			String ss = test.s;
			int ii = test.i;
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");
		System.out.println("\nPubliczne - odczyt (" + COUNT_2 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int i = 0; i < COUNT_2; i++){
			String ss = test.s;
			int ii = test.i;
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");
		System.out.println("\nPubliczne - odczyt (" + COUNT_3 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int i = 0; i < COUNT_3; i++){
			String ss = test.s;
			int ii = test.i;
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");

		//////////////////////////////

		//rozgrzewka
		for(int i = 0; i < PRE_RUN; i++){
			String ss = test.getPrivS();
			int ii = test.getPrivI();
		}

		System.out.println("\nPrywatne - odczyt (" + COUNT_1 + " wywolan):");
		startTime = System.currentTimeMillis();
		for(int i = 0; i < COUNT_1; i++){
			String ss = test.getPrivS();
			int ii = test.getPrivI();
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");
		System.out.println("\nPrywatne - odczyt (" + COUNT_2 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int i = 0; i < COUNT_2; i++){
			String ss = test.getPrivS();
			int ii = test.getPrivI();
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");
		System.out.println("\nPrywatne - odczyt (" + COUNT_3 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int i = 0; i < COUNT_3; i++){
			String ss = test.getPrivS();
			int ii = test.getPrivI();
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");


		//2. Zapis
		//rozgrzewka
		for(int i = 0; i < PRE_RUN; i++){
			test.s = "Rozgrzewka";
			test.i = 111;
		}

		System.out.println("\nPubliczne zapis (" + COUNT_1 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int i = 0; i < COUNT_1; i++){
			test.s = "Ben";
			test.i = 1111;
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");
		System.out.println("\nPubliczne zapis (" + COUNT_2 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int i = 0; i < COUNT_2; i++){
			test.s = "Ben";
			test.i = 1111;
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");
		System.out.println("\nPubliczne - zapis (" + COUNT_3 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int i = 0; i < COUNT_3; i++){
			test.s = "Ben";
			test.i = 1111;
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");

		///////////////////////////////////

		//rozgrzewka
		for(int i = 0; i < PRE_RUN; i++){
			test.setPrivS("Rozgrzewka");
			test.setPrivI(111);
		}

		System.out.println("\nPrywatne - zapis (" + COUNT_1 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int i = 0; i < COUNT_1; i++){
			test.setPrivS("Ben");
			test.setPrivI(1111);
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");
		System.out.println("\nPrywatne - zapis (" + COUNT_2 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int i = 0; i < COUNT_2; i++){
			test.setPrivS("Ben");
			test.setPrivI(1111);
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");
		System.out.println("\nPrywatne - zapis (" + COUNT_3 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int i = 0; i < COUNT_3; i++){
			test.setPrivS("Ben");
			test.setPrivI(1111);
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");

		//3. Wywolanie prostej metody
		//rozgrzewka

		for(int i = 0; i < PRE_RUN; i ++){
			test.testMethod();
		}

		System.out.println("\nMetoda (" + COUNT_1 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int i = 0; i < COUNT_1; i++){
			test.testMethod();
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");
		System.out.println("\nMetoda (" + COUNT_2 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int i = 0; i < COUNT_2; i++){
			test.testMethod();
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");
		System.out.println("\nMetoda (" + COUNT_3 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int i = 0; i < COUNT_3; i++){
			test.testMethod();
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");

	}

	//przez interfejs
	public static void benSecond(TestClass test){
		//1. Odczyt
		//rozgrzewka
		for(int i = 0; i < PRE_RUN; i++){
			String ss = test.getS();
			int ii = test.getI();
		}

		System.out.println("-------------------------------------\n"
				+ "###  Dostep przez interfejs do pol ###\n\n"
				+ "Publiczne - odczyt (" + COUNT_1 + " wywolan):");

		long startTime = System.currentTimeMillis();
		for(int i = 0; i < COUNT_1; i++){
			String ss = test.getS();
			int ii = test.getI();
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");
		System.out.println("\nPubliczne - odczyt (" + COUNT_2 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int i = 0; i < COUNT_2; i++){
			String ss = test.getS();
			int ii = test.getI();
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");
		System.out.println("\nPubliczne - odczyt (" + COUNT_3 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int i = 0; i < COUNT_3; i++){
			String ss = test.getS();
			int ii = test.getI();
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");

		//////////////////////////////

		//rozgrzewka
		for(int i = 0; i < PRE_RUN; i++){
			String ss = test.getPrivS();
			int ii = test.getPrivI();
		}

		System.out.println("\nPrywatne - odczyt (" + COUNT_1 + " wywolan):");
		startTime = System.currentTimeMillis();
		for(int i = 0; i < COUNT_1; i++){
			String ss = test.getPrivS();
			int ii = test.getPrivI();
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");
		System.out.println("\nPrywatne - odczyt (" + COUNT_2 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int i = 0; i < COUNT_2; i++){
			String ss = test.getPrivS();
			int ii = test.getPrivI();
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");
		System.out.println("\nPrywatne - odczyt (" + COUNT_3 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int i = 0; i < COUNT_3; i++){
			String ss = test.getPrivS();
			int ii = test.getPrivI();
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");


		//2. Zapis
		//rozgrzewka
		for(int i = 0; i < PRE_RUN; i++){
			test.setS("Rozgrzewka");
			test.setI(111);
		}

		System.out.println("\nPubliczne zapis (" + COUNT_1 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int i = 0; i < COUNT_1; i++){
			test.setS("Ben");
			test.setI(1111);
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");
		System.out.println("\nPubliczne zapis (" + COUNT_2 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int i = 0; i < COUNT_2; i++){
			test.setS("Ben");
			test.setI(1111);
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");
		System.out.println("\nPubliczne - zapis (" + COUNT_3 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int i = 0; i < COUNT_3; i++){
			test.setS("Ben");
			test.setI(1111);
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");

		///////////////////////////////////

		//rozgrzewka
		for(int i = 0; i < PRE_RUN; i++){
			test.setPrivS("Rozgrzewka");
			test.setPrivI(111);
		}

		System.out.println("\nPrywatne - zapis (" + COUNT_1 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int i = 0; i < COUNT_1; i++){
			test.setPrivS("Ben");
			test.setPrivI(1111);
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");
		System.out.println("\nPrywatne - zapis (" + COUNT_2 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int i = 0; i < COUNT_2; i++){
			test.setPrivS("Ben");
			test.setPrivI(1111);
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");
		System.out.println("\nPrywatne - zapis (" + COUNT_3 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int i = 0; i < COUNT_3; i++){
			test.setPrivS("Ben");
			test.setPrivI(1111);
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");

		//3. Wywolanie prostej metody
		//rozgrzewka

		for(int i = 0; i < PRE_RUN; i ++){
			test.testMethod();
		}

		System.out.println("\nMetoda (" + COUNT_1 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int i = 0; i < COUNT_1; i++){
			test.testMethod();
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");
		System.out.println("\nMetoda (" + COUNT_2 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int i = 0; i < COUNT_2; i++){
			test.testMethod();
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");
		System.out.println("\nMetoda (" + COUNT_3 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int i = 0; i < COUNT_3; i++){
			test.testMethod();
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");

	}

	//przez refleksje
	public static void benThird(TestClassImpl test) throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		Field s = test.getClass().getField("s");
		Field i = test.getClass().getField("i");

		Field privS = test.getClass().getDeclaredField("privS");
		privS.setAccessible(true);
		Field privI = test.getClass().getDeclaredField("privI");
		privI.setAccessible(true);

		Method testMethod = test.getClass().getMethod("testMethod");

		//rozgrzewka
		for(int j = 0; j < PRE_RUN; j++){
			String ss = (String) s.get(test);
			int ii = i.getInt(test);
		}

		System.out.println("-------------------------------------\n"
				+ "###  Dostep przez refleksje do pol ###\n\n"
				+ "Publiczne - odczyt (" + COUNT_1 + " wywolan):");

		long startTime = System.currentTimeMillis();
		for(int j = 0; j < COUNT_1; j++){
			String ss = (String) s.get(test);
			int ii = i.getInt(test);
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");
		System.out.println("\nPubliczne - odczyt (" + COUNT_2 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int j = 0; j < COUNT_2; j++){
			String ss = (String) s.get(test);
			int ii = i.getInt(test);
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");
		System.out.println("\nPubliczne - odczyt (" + COUNT_3 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int j = 0; j < COUNT_3; j++){
			String ss = (String) s.get(test);
			int ii = i.getInt(test);
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");

		//////////////////////////////

		//rozgrzewka
		for(int j = 0; j < PRE_RUN; j++){
			String ss = (String) privS.get(test);
			int ii = privI.getInt(test);
		}

		System.out.println("\nPrywatne - odczyt (" + COUNT_1 + " wywolan):");
		startTime = System.currentTimeMillis();
		for(int j = 0; j < COUNT_1; j++){
			String ss = (String) privS.get(test);
			int ii = privI.getInt(test);
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");
		System.out.println("\nPrywatne - odczyt (" + COUNT_2 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int j = 0; j < COUNT_2; j++){
			String ss = (String) privS.get(test);
			int ii = privI.getInt(test);
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");
		System.out.println("\nPrywatne - odczyt (" + COUNT_3 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int j = 0; j < COUNT_3; j++){
			String ss = (String) privS.get(test);
			int ii = privI.getInt(test);
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");


		//2. Zapis
		//rozgrzewka
		for(int j = 0; j < PRE_RUN; j++){
			s.set(test, "Rozgrzewka");
			i.setInt(test, 111);
		}

		System.out.println("\nPubliczne zapis (" + COUNT_1 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int j = 0; j < COUNT_1; j++){
			s.set(test, "Ben");
			i.setInt(test, 1111);
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");
		System.out.println("\nPubliczne zapis (" + COUNT_2 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int j = 0; j < COUNT_2; j++){
			s.set(test, "Ben");
			i.setInt(test, 1111);
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");
		System.out.println("\nPubliczne - zapis (" + COUNT_3 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int j = 0; j < COUNT_3; j++){
			s.set(test, "Ben");
			i.setInt(test, 1111);
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");

		///////////////////////////////////

		//rozgrzewka
		for(int j = 0; j < PRE_RUN; j++){
			privS.set(test, "Rozgrzewka");
			privI.setInt(test, 111);
		}

		System.out.println("\nPrywatne - zapis (" + COUNT_1 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int j = 0; j < COUNT_1; j++){
			privS.set(test, "Ben");
			privI.setInt(test, 1111);
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");
		System.out.println("\nPrywatne - zapis (" + COUNT_2 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int j = 0; j < COUNT_2; j++){
			privS.set(test, "Ben");
			privI.setInt(test, 1111);
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");
		System.out.println("\nPrywatne - zapis (" + COUNT_3 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int j = 0; j < COUNT_3; j++){
			privS.set(test, "Ben");
			privI.setInt(test, 1111);
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");

		//3. Wywolanie prostej metody
		//rozgrzewka

		for(int j = 0; j < PRE_RUN; j++){
			testMethod.invoke(test);
		}

		System.out.println("\nMetoda (" + COUNT_1 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int j = 0; j < COUNT_1; j++){
			testMethod.invoke(test);
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");
		System.out.println("\nMetoda (" + COUNT_2 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int j = 0; j < COUNT_2; j++){
			testMethod.invoke(test);
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");
		System.out.println("\nMetoda (" + COUNT_3 + " wywolan):");

		startTime = System.currentTimeMillis();
		for(int j = 0; j < COUNT_3; j++){
			testMethod.invoke(test);
		}
		System.out.println(((double)(System.currentTimeMillis() - startTime))/ 1000.0 + " s");

	}

}
