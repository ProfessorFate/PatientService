package com.example.patientservice.application;

import com.example.patientservice.annotation.UseCase;
import com.example.patientservice.application.usecase.PatientServiceUseCase;
import com.example.patientservice.domain.Patient;
import com.example.patientservice.ports.DeletePatientPort;
import com.example.patientservice.ports.SavePatientPort;
import com.example.patientservice.ports.SearchPatientPort;
import com.example.patientservice.ports.UpdatePatientPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


@UseCase
@RequiredArgsConstructor
@Slf4j
public class PatientService implements PatientServiceUseCase {

    private final SearchPatientPort searchPatientPort;
    private final SavePatientPort savePatientPort;
    private final UpdatePatientPort updatePatientPort;
    private final DeletePatientPort deletePatientPort;

    @Override
    public List<Patient> getPatients() {
        return searchPatientPort.searchPatient();

    }

    @Override
    public Patient getPatientById(String id) {
        return searchPatientPort.getPatientById(id);
    }

    @Override
    public void savePatient(Patient patient) {
        savePatientPort.savePatient(patient);

    }

    @Override
    public void updatePatient(Patient patient) {
        Patient findPatient = searchPatientPort.getPatientById(patient.getId());

        findPatient.setId(patient.getId());
        findPatient.setName(patient.getName());
        findPatient.setGender(patient.getGender());
        findPatient.setBirthDate(patient.getBirthDate());

        updatePatientPort.updatePatient(findPatient);

    }

    @Override
    public void deletePatient(Patient patient) {
        deletePatientPort.deletePatient(patient.getId());

    }

    @Override
    public List<Patient> createOneHundredPatient() {

        List<String> genderList = new ArrayList<>(Arrays.asList("male", "female"));
        List<String> lastNames = new ArrayList<>(Arrays.asList("Попов", "Завьялова", "Щербакова", "Иванов", "Назарова", "Климова", "Беспалова", "Яковлев", "Соболева", "Давыдов", "Сидоров", "Семенова", "Сергеев", "Бирюков", "Герасимов", "Яковлев", "Волков", "Евдокимова", "Казаков", "Сергеева", "Волков", "Иванов", "Громова", "Маслова", "Русакова", "Архипов", "Большаков", "Балашов ", "Федотова", "Емельянова", "Галкина", "Степанова", "Хохлова", "Сергеева ", "Ершов", "Мартынова", "Александров", "Скворцова ", "Потапова ", "Калинина ", "Парфенов ", "Королев", "Беляев", "Морозова", "Свиридова", "Тихонов", "Лавров", "Леонова ", "Кузнецова", "Мальцев", "Смирнов ", "Шубин ", "Софронов ", "Степанов ", "Смирнова ", "Моисеева ", "Назаров ", "Тихонова", "Шувалов ", "Попова ", "Устинова ", "Александрова ", "Фокина ", "Поляков ", "Иванов ", "Русанова", "Нестеров", "Соколов", "Волков ", "Попов ", "Воробьева ", "Громова ", "Филимонов", "Соловьев ", "Михайлов ", "Латышев ", "Любимова ", "Кудрявцев", "Фетисов", "Соколов", "Прохорова", "Васильева", "Мухин", "Зорина", "Олейникова", "Маслова", "Успенский", "Беляев", "Уткин", "Максимов", "Калинина", "Семенова", "Иванов", "Гордеева", "Новикова", "Шмелева", "Усов", "Виноградов", "Ермилова", "Крылова"));
        List<String> firstNames = new ArrayList<>(Arrays.asList("Милана", "Ульяна", "Варвара", "Иван", "София", "Захар", "Алиса", "Николь", "Ева", "Евгения", "Владислав", "Алина", "Сабина", "Анастасия", "Максим", "Владимир", "Арина", "Александр", "Роман", "Дмитрий", "Сафия", "Маргарита", "Денис", "Таисия", "Илья", "Мария", "Юлия", "Валерия", "Эмиль", "Лев", "Дарья", "Тимур", "Егор", "Артём", "Андрей", "Полина", "Руслан", "Серафима", "Макар", "Александра", "Нина", "Аврора", "Кирилл", "Василиса", "Светлана", "Надежда", "Камилла", "Вероника", "Алексей", "Сергей", "Мия", "Екатерина", "Ксения", "Антон", "Кристина", "Степан", "Николай", "Анна", "Борис", "Евгений", "Арсений", "Марк", "Михаил", "Ольга", "Кира", "Фёдор", "Игорь", "Демьян", "Алисия", "Артур", "Елизавета", "Ирина", "Виктор", "Даниэль", "Мира", "Богдан", "Василий", "Платон", "Георгий", "Мадина", "Всеволод", "Эмир", "Григорий", "Злата", "Ярослав", "Наталья", "Дарина", "Семён", "Константин", "Владислава", "Асия", "Глеб", "Тимофей", "Амелия", "Даниил", "Алёна", "Артемий", "Виктория", "Матвей", "Роберт"));
        List<String> middleNames = new ArrayList<>(Arrays.asList("Александровна", "Глебович", "Артёмовна", "Дмитриеви", "Станиславович", "Дмитриевич", "Маркович", "Степановна", "Николаевич", " Ильинична", "Александровна", "Ильич", "Алексеевна", "Макаровна", "Артемьевич", "Степанович", "Вадимович", "Даниилович", "Владиславович", "Ярославовна", "Платонович", "Семёновна", "Максимович", "Александровна", "Артёмович", "Фёдоровна", "Петровна", "Егорович", "Константинович", "Андреевич", "Максимович", "Руслановна", "Антонович", "Данилович", "Олегович", "Дмитриевна", "Матвеевич", "Дмитриевич", "Артёмович", "Романовна", "Максимовна", "Львовна", "Платонович", "Гордеевна", "Львовна", "Максимович", "Константиновна", "Сергеевна", "Семёнович", "Кириллович", "Фёдоровна", "Георгиевна", "Маркович", "Данииловна", "Владимировна", "Ивановна", "Даниилович", "Никитич", "Григорьевна", "Александрович", "Ильич", "Ивановна", "Степанович", "Данииловна", "Дмитриевна", "Фёдорович", "Артемьевич", "Семёновна", "Максимович", "Данилович", "Денисович", "Владимирович", "Платонович", "Макарович", "Саввична", "Ильич", "Семёнович", "Даниилович", "Дмитриевич", "Миронович", "Иванович", "Андреевич", "Демьяновна", "Артурович", "Алексеевна", "Даниилович", "Дмитриевич", "Андреевна", "Артёмовна", "Артёмович", "Юрьевич", "Алексеевна", "Святославович", "Дмитриевич", "Андреевич", "Владимирович", "Чумаков Илья Маркович", "Александрович", "Михайловна", "Ильич"));

        List<Patient> patients = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            Patient patient = new Patient();

            String id = getIdRandom(random);
            String lastName = getRandomName(lastNames, random.nextInt(lastNames.size()));
            String firstName = getRandomName(firstNames, random.nextInt(firstNames.size()));
            String middleName = getRandomName(middleNames, random.nextInt(middleNames.size()));
            String gender = genderList.get(random.nextInt(genderList.size()));
            LocalDateTime birthDate = getRandomBirthDate().atStartOfDay();

            patient.setId(id);
            patient.setName(lastName + " " + firstName + " " + middleName);
            patient.setGender(gender);
            patient.setBirthDate(birthDate);
            System.out.println(patient);

            patients.add(patient);
        }

        return patients;

    }


    private LocalDate getRandomBirthDate() {
        LocalDate start = LocalDate.of(1970, Month.JANUARY, 1);
        long days = ChronoUnit.DAYS.between(start, LocalDate.now());

        return start.plusDays(new Random().nextInt((int) days + 1));
    }

    private String getRandomName(List<String> list, int index) {
        String str = list.get(index);
        list.remove(index);

        return str;
    }

    private String getIdRandom(Random random) {
        int length = 36;

        return random.ints(48, 122)
                .filter(i -> (i < 57 || i > 65) && (i < 90 || i > 97))
                .mapToObj(i -> (char) i)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();

    }

}
