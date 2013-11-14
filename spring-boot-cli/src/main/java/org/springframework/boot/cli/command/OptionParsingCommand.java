/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.cli.command;

import java.util.Collection;

import org.springframework.boot.cli.Command;
import org.springframework.boot.cli.OptionHelp;

/**
 * Base class for a {@link Command} that parse options using an {@link OptionHandler}.
 * 
 * @author Phillip Webb
 * @author Dave Syer
 * @see OptionHandler
 */
public abstract class OptionParsingCommand extends AbstractCommand {

	private OptionHandler handler;

	protected OptionParsingCommand(String name, String description, OptionHandler handler) {
		this(name, description, false, handler);
	}

	protected OptionParsingCommand(String name, String description,
			boolean optionCommand, OptionHandler handler) {
		super(name, description, optionCommand);
		this.handler = handler;
	}

	@Override
	public String getHelp() {
		return this.handler.getHelp();
	}

	@Override
	public Collection<OptionHelp> getOptionsHelp() {
		return this.handler.getOptionsHelp();
	}

	@Override
	public final void run(String... args) throws Exception {
		this.handler.run(args);
	}

	protected OptionHandler getHandler() {
		return this.handler;
	}

}