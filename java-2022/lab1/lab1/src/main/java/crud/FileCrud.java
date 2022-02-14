package crud;
import FileIO.FileIO;
import FileIO.FileIOInterface;
import crud.Lab2CrudInterface;
import phones.phones;

public class FileCrud implements Lab2CrudInterface {

	FileIOInterface fio;
	
	public FileCrud() {
		this.fio = new FileIO();
	}
	
	@Override
	public phones readPhones() {

		
		
		return (phones)fio.loadFromFile();
	}

	@Override
	public void updatePhones(phones phones) {

		fio.saveToFile(phones);
		
	}

}
