create table websites (
	webId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	expireDate DATE null,
	renewDate DATE null,
	price DOUBLE,
	active_ BOOLEAN,
	transitionId VARCHAR(75) null
);

create table websitesdashboard (
	webId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	expireDate DATE null,
	renewDate DATE null,
	price DOUBLE,
	active_ BOOLEAN,
	transitionId VARCHAR(75) null,
	status VARCHAR(75) null,
	comments VARCHAR(75) null
);