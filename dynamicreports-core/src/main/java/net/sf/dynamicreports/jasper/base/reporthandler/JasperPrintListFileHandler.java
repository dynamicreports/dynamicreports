/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca
 * http://www.dynamicreports.org
 *
 * This file is part of DynamicReports.
 *
 * DynamicReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * DynamicReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.jasper.base.reporthandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import net.sf.dynamicreports.report.exception.DRReportException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRVirtualizer;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;

/**
 * <p>JasperPrintListFileHandler class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class JasperPrintListFileHandler extends AbstractPrintListHandler {
	private static final String TEMP_FILE_PREFIX = "JasperPrint";

	private List<JasperPrint> printList;
	private List<File> tempFiles;
	private File directory;
	private JRVirtualizer virtualizer;

	/**
	 * <p>Constructor for JasperPrintListFileHandler.</p>
	 *
	 * @param directory a {@link java.lang.String} object.
	 */
	public JasperPrintListFileHandler(String directory) {
		this(directory, null);
	}

	/**
	 * <p>Constructor for JasperPrintListFileHandler.</p>
	 *
	 * @param directory a {@link java.lang.String} object.
	 * @param virtualizer a {@link net.sf.jasperreports.engine.JRVirtualizer} object.
	 */
	public JasperPrintListFileHandler(String directory, JRVirtualizer virtualizer) {
		this.virtualizer = virtualizer;
		if (directory != null) {
			this.directory = new File(directory);
		}
		printList = new PrintList();
		tempFiles = new ArrayList<File>();
	}

	/** {@inheritDoc} */
	@Override
	protected void add(JasperPrint jasperPrint) {
		try {
			File tempFile = File.createTempFile(TEMP_FILE_PREFIX, null, directory);
			JRSaver.saveObject(jasperPrint, tempFile);
			tempFiles.add(tempFile);
		} catch (JRException e) {
			throw new DRReportException(e);
		} catch (IOException e) {
			throw new DRReportException(e);
		}
	}

	/** {@inheritDoc} */
	@Override
	public List<JasperPrint> getPrintList() {
		return printList;
	}

	/** {@inheritDoc} */
	@Override
	protected void finalize() throws Throwable {
		for (File tempFile : tempFiles) {
			tempFile.delete();
		}
		super.finalize();
	}

	private class PrintList implements List<JasperPrint> {

		@Override
		public int size() {
			return tempFiles.size();
		}

		@Override
		public boolean isEmpty() {
			return tempFiles.isEmpty();
		}

		@Override
		public boolean contains(Object o) {
			throw new UnsupportedOperationException();
		}

		@Override
		public Iterator<JasperPrint> iterator() {
			return new Iterator<JasperPrint>() {
				private Iterator<File> it = tempFiles.iterator();

				@Override
				public boolean hasNext() {
					return it.hasNext();
				}

				@Override
				public JasperPrint next() {
					File tempFile = it.next();
					try {
						JasperPrint jasperPrint = JRLoader.loadJasperPrint(tempFile, virtualizer);
						return jasperPrint;
					} catch (JRException e) {
						throw new DRReportException(e);
					}
				}

				@Override
				public void remove() {
					throw new UnsupportedOperationException();
				}

			};
		}

		@Override
		public Object[] toArray() {
			throw new UnsupportedOperationException();
		}

		@Override
		public <T> T[] toArray(T[] a) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean add(JasperPrint o) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean remove(Object o) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean addAll(Collection<? extends JasperPrint> c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean addAll(int index, Collection<? extends JasperPrint> c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void clear() {
			throw new UnsupportedOperationException();
		}

		@Override
		public JasperPrint get(int index) {
			try {
				File tempFile = tempFiles.get(index);
				JasperPrint jasperPrint = JRLoader.loadJasperPrint(tempFile, virtualizer);
				return jasperPrint;
			} catch (JRException e) {
				throw new DRReportException(e);
			}
		}

		@Override
		public JasperPrint set(int index, JasperPrint element) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(int index, JasperPrint element) {
			throw new UnsupportedOperationException();
		}

		@Override
		public JasperPrint remove(int index) {
			throw new UnsupportedOperationException();
		}

		@Override
		public int indexOf(Object o) {
			throw new UnsupportedOperationException();
		}

		@Override
		public int lastIndexOf(Object o) {
			throw new UnsupportedOperationException();
		}

		@Override
		public ListIterator<JasperPrint> listIterator() {
			throw new UnsupportedOperationException();
		}

		@Override
		public ListIterator<JasperPrint> listIterator(int index) {
			throw new UnsupportedOperationException();
		}

		@Override
		public List<JasperPrint> subList(int fromIndex, int toIndex) {
			throw new UnsupportedOperationException();
		}
	}
}
